package com.lj.common.core.utils;

import java.nio.charset.Charset;
import java.util.Map;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.lj.common.core.exception.BizException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * okHttp工具类
 *
 * @author: gzc
 * @createTime: 2022-3-16 10:59
 * @since: 1.0
 **/
public class OkHttpUtil {

	private static final Logger log = LoggerFactory.getLogger(OkHttpUtil.class);

	public static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");
	public static final MediaType XML_MEDIA_TYPE = MediaType.parse("application/xml; charset=utf-8");
	private static Charset CHARSET = CharsetUtil.CHARSET_UTF_8;


	private static OkHttpClient okHttpClient;

	@Autowired
	private void setOkHttpClient(OkHttpClient okHttpClient) {
		OkHttpUtil.okHttpClient = okHttpClient;
	}

	/**
	 * get 请求
	 *
	 * @param url 请求url地址
	 * @return string
	 */
	public static String doGet(String apiMsg, String url) {
		return executeGet(apiMsg, url, null, null);
	}


	/**
	 * get 请求
	 *
	 * @param url      请求url地址
	 * @param paramMap 请求参数 map
	 * @return string
	 */
	public static String doGet(String apiMsg, String url, Map<String, String> paramMap) {
		return executeGet(apiMsg, url, paramMap, null);
	}

	/**
	 * get 请求
	 *
	 * @param url 请求url地址
	 *            //	 * @param headers 请求头字段 {k1, v1 k2, v2, ...}
	 * @return string
	 */
	public static String doGetHeader(String apiMsg, String url, Map<String, String> headMap) {
		return executeGet(apiMsg, url, null, headMap);
	}


	/**
	 * get 请求
	 *
	 * @param url      请求url地址
	 * @param paramMap 请求参数 map
	 *                 //	 * @param headers  请求头字段 {k1, v1 k2, v2, ...}
	 * @return string
	 */
	public static String executeGet(String apiMsg, String url, Map<String, String> paramMap,
									Map<String, String> headMap) {
		log.info("调用{}, 请求路径为{}, 请求参数为{}", apiMsg, url, JSON.toJSONString(paramMap));
		StringBuilder sb;
		Request.Builder builder;
		try {
			Assert.notBlank(url, "请求路径为空");
			sb = new StringBuilder(url);
			if (paramMap != null && paramMap.keySet().size() > 0) {
				boolean firstFlag = true;
				for (String key : paramMap.keySet()) {
					if (firstFlag) {
						sb.append("?").append(key).append("=").append(paramMap.get(key));
						firstFlag = false;
					} else {
						sb.append("&").append(key).append("=").append(paramMap.get(key));
					}
				}
			}

			builder = new Request.Builder();
//			if (headers != null && headers.length > 0) {
//				if (headers.length % 2 == 0) {
//					for (int i = 0; i < headers.length; i = i + 2) {
//						builder.addHeader(headers[i], headers[i + 1]);
//					}
//				} else {
//					log.warn("headers's length[{}] is error.", headers.length);
//				}
//			}
			if (CollUtil.isNotEmpty(headMap)) {
				log.info("调用{}, 请求头为{}", apiMsg, JSON.toJSONString(headMap));
				headMap.forEach((k, v) -> builder.addHeader(k, v));
			}

		} catch (Exception e) {
			throw new BizException("调用" + apiMsg + " 拼接GET参数发生异常", e);
		}

		try {
			Request request = builder.url(sb.toString()).build();
			byte[] bytes = execute(request);
			String responseText = StrUtil.str(bytes, CHARSET);
			if (StrUtil.isBlank(responseText)) {
				throw new BizException("返回结果为空");
			}
			log.info("调用{}返回结果为{}", apiMsg, responseText);
			return responseText;
		} catch (Exception e) {
			throw new BizException("调用" + apiMsg + "发生异常, 异常原因为" + e.getMessage(), e);
		}
	}

	/**
	 * post 请求
	 *
	 * @param url    请求url地址
	 * @param params 请求参数 map
	 * @return string
	 */
//	public String doPost(String apiMsg, String url, Map<String, String> params) {
//		FormBody.Builder builder = new FormBody.Builder();
//
//		if (params != null && params.keySet().size() > 0) {
//			for (String key : params.keySet()) {
//				builder.add(key, params.get(key));
//			}
//		}
//		Request request = new Request.Builder().url(url).post(builder.build()).build();
//		log.info("do post request and url[{}]", url);
//
//		return execute(request);
//	}


	/**
	 * post 请求, 请求数据为 json 的字符串
	 *
	 * @param url  请求url地址
	 * @param json 请求数据, json 字符串
	 * @return string
	 */
	public static String doPostJson(String apiMsg, String url, String json) {
		return executePost(apiMsg, url, json, null, JSON_MEDIA_TYPE);
	}

	/**
	 * post 请求, 请求数据为 xml 的字符串
	 *
	 * @param url 请求url地址
	 * @param xml 请求数据, xml 字符串
	 * @return string
	 */
	public static String doPostXml(String apiMsg, String url, String xml) {
		return executePost(apiMsg, url, xml, null, XML_MEDIA_TYPE);
	}


	public static String executePost(String apiMsg, String url, String data,
									 Map<String, String> headMap, MediaType contentType) {
		try {
			log.info("调用{}, 请求路径为{}, 请求参数为{}", apiMsg, url, data);
			Assert.notBlank(url, "请求路径为空");
//			RequestBody requestBody = RequestBody.create(contentType, data);
			RequestBody requestBody = RequestBody.create(data, contentType);
			Request.Builder reqBuilder = new Request.Builder().url(url).post(requestBody);
			if (CollUtil.isNotEmpty(headMap)) {
				log.info("调用{}, 请求头为{}", JSON.toJSONString(headMap));
				headMap.forEach((k, v) -> reqBuilder.addHeader(k, v));
			}
			Request request = reqBuilder.build();
			// 发起请求
			byte[] bytes = execute(request);
			String responseText = StrUtil.str(bytes, CHARSET);
			if (StrUtil.isBlank(responseText)) {
				throw new BizException("返回结果为空");
			}
			log.info("调用{}返回结果为{}", apiMsg, responseText);
			return responseText;
		} catch (Exception e) {
			throw new BizException("调用" + apiMsg + "发生异常, 异常原因为" + e.getMessage(), e);
		}
	}

	private static byte[] execute(Request request) {
		Response response = null;
		try {
			response = okHttpClient.newCall(request).execute();
			if (response.isSuccessful()) {
				return response.body().bytes();
			}
		} catch (Exception e) {
			throw new BizException(e.getMessage(), e);
		} finally {
			if (response != null) {
				response.close();
			}
		}
		return new byte[0];
	}


}

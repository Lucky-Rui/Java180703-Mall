package com.situ.mall.util;

/**
 * 七牛云
 * 
 * @author WANGRUI
 *
 */
public class QiniuUtil {
	private static final String accessKey = "U_DBvA2v-Fq22-N5ayc-Yc-aiTql2oFp1SMHJTfS";
	private static final String secretKey = "7cKiobWN5Ga7gUKBU8qTs9s2dt6aTAnd9Y5cwK33";
	private static final String bucket = "java1807mall";

	private static Auth auth;
	private static UploadManager uploadManager;

	static {
		// 构造一个带指定Zone对象的配置类
		auth = Auth.create(accessKey, secretKey);
		Configuration cfg = new Configuration(Zone.zone0());
		// ...其他参数参考类注释
		uploadManager = new UploadManager(cfg);
	}

	/*
	 * 上传单张图片，返回值是图片在七牛服务器上的名字
	 */
	public static String uploadImage(byte[] buffer) {
		String key = null;
		String upToken = auth.uploadToken(bucket);
		try {
			Response response = uploadManager.put(buffer, key, upToken);
			// 解析上传成功的结果
			DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
			System.out.println(putRet.key);
			System.out.println(putRet.hash);
			return putRet.key;
		} catch (QiniuException ex) {
			Response r = ex.response;
			System.err.println(r.toString());
			try {
				System.err.println(r.bodyString());
			} catch (QiniuException ex2) {
				// ignore
			}
		}
		return "";
	}
}

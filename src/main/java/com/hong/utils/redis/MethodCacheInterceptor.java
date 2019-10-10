//package com.hong.utils.redis;
//
//import org.aopalliance.intercept.MethodInterceptor;
//import org.aopalliance.intercept.MethodInvocation;
//import org.apache.log4j.Logger;
//import sun.rmi.runtime.Log;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Properties;
//
///**
// * @Author: Seth
// * @Description: AOP,先到Redis缓存中看是否有数据，没有再到其他数据库查询
// * @Date: Created in 12:56 2019/9/3
// */
//
//public class MethodCacheInterceptor implements MethodInterceptor {
//    private Logger logger = Logger.getLogger(MethodCacheInterceptor.class);
//    private RedisUtil redisUtil;
//    private List<String> targetNamesList; // 不加入缓存的service名称
//    private List<String> methodNamesList; // 不加入缓存的方法名称
//    private Long defaultCacheExpireTime; // 缓存默认的过期时间
//    private Long xxxRecordManagerTime; //
//    private Long xxxSetRecordManagerTime; //
//
//
//    public MethodCacheInterceptor() {
//        try {
//            File f = new File("D:\\cacheConf.properties");
//            //配置文件位置直接被写死，有需要自己修改下
//            InputStream in = new FileInputStream(f);
////			InputStream in = getClass().getClassLoader().getResourceAsStream(
////					"D:\\lunaJee-workspace\\msm\\msm_core\\src\\main\\java\\com\\mucfc\\msm\\common\\cacheConf.properties");
//            Properties p = new Properties();
//            p.load(in);
//            // 分割字符串
//            String[] targetNames = p.getProperty("targetNames").split(",");
//            String[] methodNames = p.getProperty("methodNames").split(",");
//
//            // 加载过期时间设置
//            defaultCacheExpireTime = Long.valueOf(p.getProperty("defaultCacheExpireTime"));
//            xxxRecordManagerTime = Long.valueOf(p.getProperty("com.service.impl.xxxRecordManager"));
//            xxxSetRecordManagerTime = Long.valueOf(p.getProperty("com.service.impl.xxxSetRecordManager"));
//            // 创建list
//            targetNamesList = new ArrayList<String>(targetNames.length);
//            methodNamesList = new ArrayList<String>(methodNames.length);
//            Integer maxLen = targetNames.length > methodNames.length ? targetNames.length
//                    : methodNames.length;
//            // 将不需要缓存的类名和方法名添加到list中
//            for (int i = 0; i < maxLen; i++) {
//                if (i < targetNames.length) {
//                    targetNamesList.add(targetNames[i]);
//                }
//                if (i < methodNames.length) {
//                    methodNamesList.add(methodNames[i]);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public Object invoke(MethodInvocation invocation) throws Throwable {
//        Object value = null;
//        String targetName = invocation.getThis().getClass().getName();
//        String methodName = invocation.getMethod().getName();
//        if (!isAddCache(targetName, methodName))       // 不需要缓存的内容
//            return invocation.proceed();               // 执行方法返回结果
//        Object[] arguments = invocation.getArguments();
//        String key = getCacheKey(targetName, methodName, arguments);
//        System.out.println(key);
//        try {
//            if (redisUtil.exists(key))             // 判断是否有缓存
//                return redisUtil.get(key);
//
//            value = invocation.proceed();                       // 写入缓存
//            if (value != null) {
//                final String tkey = key;
//                final Object tvalue = value;
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (tkey.startsWith("com.service.impl.xxxRecordManager")) {
//                            redisUtil.set(tkey, tvalue, xxxRecordManagerTime);
//                        } else if (tkey.startsWith("com.service.impl.xxxSetRecordManager")) {
//                            redisUtil.set(tkey, tvalue, xxxSetRecordManagerTime);
//                        } else {
//                            redisUtil.set(tkey, tvalue, defaultCacheExpireTime);
//                        }
//                    }
//                }).start();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (value == null) {
//                return invocation.proceed();
//            }
//        }
//        return value;
//    }
//
//    /**
//     * 是否加入缓存
//     *
//     * @return
//     */
//    private boolean isAddCache(String targetName, String methodName) {
//        boolean flag = true;
//        if (targetNamesList.contains(targetName)
//                || methodNamesList.contains(methodName)) {
//            flag = false;
//        }
//        return flag;
//    }
//
//    /**
//     * 创建缓存key
//     *
//     * @param targetName
//     * @param methodName
//     * @param arguments
//     */
//    private String getCacheKey(String targetName, String methodName,
//                               Object[] arguments) {
//        StringBuffer sbu = new StringBuffer();
//        sbu.append(targetName).append("_").append(methodName);
//        if ((arguments != null) && (arguments.length != 0)) {
//            for (int i = 0; i < arguments.length; i++) {
//                sbu.append("_").append(arguments[i]);
//            }
//        }
//        return sbu.toString();
//    }
//
//    public void setRedisUtil(RedisUtil redisUtil) {
//        this.redisUtil = redisUtil;
//    }
//}
//
//

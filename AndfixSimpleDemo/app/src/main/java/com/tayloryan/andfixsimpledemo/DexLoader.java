package com.tayloryan.andfixsimpledemo;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;

import dalvik.system.DexFile;

/**
 * Created by taylor.yan on 8/25/17.
 */

public class DexLoader {

    private static final String TAG = "DexLoader";
    private Context mContext;

    public DexLoader(Context context) {
        mContext = context;
    }

    public void loadDex(File dexFilePath) {
        File cacheFile = new File(mContext.getCacheDir(), dexFilePath.getName());
        if (cacheFile.exists()) {
            cacheFile.delete();
        }
        try {
            DexFile dexFile = DexFile.loadDex(dexFilePath.getAbsolutePath(), cacheFile.getAbsolutePath(), Context.MODE_PRIVATE);
            Enumeration<String> entries = dexFile.entries();
            while (entries.hasMoreElements()) {
                String className = entries.nextElement();
                Class cls = dexFile.loadClass(className, mContext.getClassLoader());

                fix(cls);

            }

        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    private void fix(Class cls) {
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            MethodReplace replace = method.getAnnotation(MethodReplace.class);
            if (null == replace) {
                continue;
            }

            String targetClsName = replace.clazz();
            String targetMethodName = replace.method();

            try {
                Class targetClass = Class.forName(targetClsName);
                Method targetMethod = targetClass.getMethod(targetMethodName, method.getParameterTypes());
                replace(targetMethod, method);
            } catch (ClassNotFoundException e) {
                Log.e(TAG, e.getMessage());
            } catch (NoSuchMethodException e) {
                Log.e(TAG, e.getMessage());
            }
        }
    }

    private native void replace(Method targetMethod, Method fixedMethod);

}

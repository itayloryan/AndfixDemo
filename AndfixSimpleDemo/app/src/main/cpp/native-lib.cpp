#include <jni.h>
#include <string>

JNIEXPORT void JNICALL

extern "C"

JNIEXPORT void JNICALL
Java_com_tayloryan_andfixsimpledemo_DexLoader_replace(JNIEnv *env, jobject instance,
                                                      jobject targetMethod, jobject fixedMethod) {
    env -> FromReflectedMethod(targetMethod);

}
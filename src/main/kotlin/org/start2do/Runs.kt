package org.start2do.processor

import org.jboss.forge.roaster.Roaster
import org.jboss.forge.roaster.model.source.JavaClassSource
import java.io.FileInputStream
import java.io.FileOutputStream
import java.lang.reflect.Method

/**
 * @Author Lijie
 * @date  2021/5/23:16:04
 */
fun main() {
    val url = "/Volumes/Project/Project/self/java/agent_test/processor/src/main/java/Demo.java"
    val parse = Roaster.parse(JavaClassSource::class.java, FileInputStream(url))
    val methodSource = parse.addMethod().setStatic(true).setPublic()
        .setName("main")
    methodSource.addParameter(Array<String>::class.java,"strings")
    methodSource.body="""
         System.out.println("Hello World");
    """.trimIndent()

    val outputStream = FileOutputStream(url)
    outputStream.write(parse.toString().toByteArray())
    outputStream.flush()
    outputStream.close()
}


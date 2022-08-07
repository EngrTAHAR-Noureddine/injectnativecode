package com.example.injectnativecode

import android.os.Build
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel


class MainActivity: FlutterActivity() {
    private val CHANNEL = "test"

    override fun configureFlutterEngine( flutterEngine: FlutterEngine) {

        super.configureFlutterEngine(flutterEngine)

        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
            run {
                if (call.method == "getResult") {

                    var count:Int? = call.argument<String>("count")?.toInt()
                    println(
                        count
                    )
                    if(count == null ) count = 0
                    result.success( count +1)

                } else {
                    result.notImplemented()
                }
            }
        }
    }
}

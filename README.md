# click-debounce
app ：
- 需要依赖 click-debounce-runtime 
- 需要依赖 click-debounce-gradle-plugin 这个插件模块的插件 
  
buildscript {
  ext.kotlin_version = '1.3.61'
  repositories {
  mavenCentral()
        google()
        jcenter()
    //添加自己的maven

    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.3.2'
//        classpath 'com.harry.plugin:debounceclick:1.0.1'  gradle插件，需要自己上传maven
    }
}
apply plugin: 'clickdebounce'  //插件的id
- click-debounce-gradle-plugin这个插件也需要依赖 click-debounce-runtime  最好都上传maven包


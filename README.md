# android-mvvm-pattern-example

Notes taking app, following the MVVM architectural pattern

![Repository](https://user-images.githubusercontent.com/90695071/233838354-206f2dae-62ca-4983-9d59-b05256e488c8.png)


### Project Structure:

         mvvm
          ├── Model
               ├── Data
               ├── Dao
               ├── Repository
          ├── View                
          ├── View Model        

### Gradle dependencies:

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    def room_version = "2.5.1"
    implementation "androidx.room:room-runtime:$room_version"
    annotationProcessor "androidx.room:room-compiler:$room_version"
    kapt "androidx.room:room-compiler:$room_version"
    implementation("androidx.room:room-ktx:2.5.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.0-RC")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.0-RC")






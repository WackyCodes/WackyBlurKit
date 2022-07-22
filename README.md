# WackyBlurKit
**Welcome to the WackyBlurKit !**

**First of All I thank to [@CameraKit](https://github.com/CameraKit). This is copy version of [blurkit](https://github.com/CameraKit/blurkit-android)**
And This is just starting version. I will update it and release with many other features.

WackyBlurKit is used to add glassy effect.

**To Use this library just follow the simple steps given below -**

## Step : 1 - 
Add `jitpack.io` in the Project Level _build.gradle_ file
```groovy
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```
Add `dependencies` in the Module Level _build.gradle_ file 
( **Use Current Version** - [![](https://jitpack.io/v/WackyCodes/WackyBlurKit.svg)](https://jitpack.io/#WackyCodes/WackyBlurKit) )
```groovy
dependencies {
       implementation 'com.github.WackyCodes:WackyBlurKit:1.0.1'
}
```

## Step : 2 -

Add Root Layout as shown below -

```xml
    <!-- Remember : BlurLayout has been extends of FrameLayout   -->
    <com.wackycodes.wackyblurkit.BlurLayout
        android:layout_width="240dp"
        android:layout_height="120dp"
        android:layout_marginTop="284dp"
        app:blk_cornerRadius="24dp"
        app:blk_blurRadius="5"
        android:elevation="24dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.729"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">

    <!-- Use Your Layout  -->
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_margin="8dp"
            android:orientation="vertical">

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:gravity="center"
                android:layout_margin="8dp"
                android:text="This is BlurKit!"
                android:textColor="#FFFFFF"
                android:textSize="16sp"/>

        </LinearLayout>

    </com.wackycodes.wackyblurkit.BlurLayout>
```

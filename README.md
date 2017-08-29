[![Release](https://jitpack.io/v/grzechu92/frogment.svg)](https://jitpack.io/#grzechu92/frogment)
[![](https://jitpack.io/v/grzechu92/frogment/month.svg)](https://jitpack.io/#grzechu92/frogment)

# Frogment

![Feels good man pepe here](http://i0.kym-cdn.com/entries/icons/original/000/000/142/feelsgoodman.png)

Simple Android framework focused on communication between components (`Activity` and `Fragment`) including managing their state.

## Implementation

```
compile "com.github.grzechu92:frogment:1.0.0-alpha8"
```

Library is published in `jitpack.io` repository, if it isn't available in your project, add lines below to matching `build.gradle` file.

```
repositories {
    maven { url 'https://jitpack.io' }
}
```

# Usage

## Binding `Frogment` library

You will need to bind `Frogment` to application. Library uses Android component lifecycle callbacks to manage objects state. Simple default configuration looks like this:

```java
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        new Frogment(this);
    }
}
```

In near future some configuration possibilities will be added. For now we've got empty builder which will be used to specify behavior of the library.

```java
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        
        new Frogment.Builder(this)
                .build();
    }
}
```

## Simple implementation

We have got here one activity called `MainActivity` and two fragments `FragmentA` and `FragmentB`

#### Our `MainActivity` XML layoyt looks like this:

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <LinearLayout
        android:id="@+id/fragment_container"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="horizontal" />
</LinearLayout>
```

Notice `fragment_container` ID of element where fragments will be injected using `FragmentManager`

#### Activity code:

```java
public class Activity extends FrogmentActivity {
    public Activity() {
        super(R.id.fragment_container);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_with_container);

        super.onCreate(savedInstanceState); //must be called after setContentView()
    }

    @Override
    protected FrogmentData getDefaultFrogmentData() {
        return FrogmentData.forClass(FragmentA.class);
    }
}
```

We need to extend `FrogmentActivity` class that contains necessary boilerplate code. `FrogmentActivity` has constructor where we need to pass container layout ID, in this case `fragment_container`. Notice that `super.onCreate()` method **is called after** `setContentView()` because library magic is called in `onCreate()` activity callback, and views have to be ready at this moment.

Last important thing there is required method `getDefaultFrogmentData` which provides default `FrogmentData` that Activity should render if nothing else is explicitly defined (check `app` sample application for more details)

#### Fragment code:

```java
public class FragmentA extends Frogment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a_layout, container, false);
    }
}
```

Nothing fancy there, instead of extending `Fragment` class, we will have to implement `Frogment` class provided by library.

### Result

At this moment we should have `FragmentA` displayed in `MainActivity` layout without as much boilerplate as using raw Android implementation.

## Fragment switching from fragment

According to previous example with `MainActivity`, `FragmentA` and `FragmentB` at some point we will need to switch fragments, because user may get bored of `FragmentA` content. To perform switch operation from fragment perspective we need to call:

```java
final FrogmentData data = FrogmentData.forClass(FragmentB.class);
getFrogmentActivity().switchFrogment(data);
```

Method `getFrogmentActivity()` is provided by `Frogment` object that we extended instead of Android `Fragment` one. It's all about passing `FrogmentData` with data about target fragment to `switchFrogment()` method. Library will handle the rest.

## Fragment switching from activity

Instead of calling `getFrogmentActivity().switchFrogment()` with `FragmentData`, just call:

```java
final FrogmentData data = FrogmentData.forClass(FragmentB.class);
switchFrogment(data);
```

Because we are already in `FrogmentActivity` context.

# For more advanced usage, check `app` module containing working sample with some Espresso tests.

#### &copy; Grze.ch (Grzegorz Borkowski) - Released under MIT License
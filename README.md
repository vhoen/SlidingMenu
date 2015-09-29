# Sliding Menu

## Install

Add the following in build.gradle
```
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```

Add the following in app/build.gradle
```
android {
    dependencies {
        compile 'com.github.vhoen:SlidingMenu:1.0.14'
    }
}
```

## Use

The activity must extend BaseActivity.
```java
public class MainActivity extends BaseActivity {
}
```

Then, the activity must implement three methods : 
```java
/**
 * This is called when the menu home button is pressed.
 * 
 */
@Override
protected void goHome() {
    //do something, such as open home fragment, or do nothing.
}

/**
 * Returns an arraylist that will be used to display the side menu
 */
@Override
protected ArrayList<me.hoen.slidingmenu.MenuItem> getSlidingMenuItems(){
    final ArrayList<MenuItem> list = new ArrayList<>();

    list.add(new MenuItem(getString(R.string.first_menu_item)));

    return list;
}

/**
 * Will be called when a menu item is pressed
 */
@Override
protected void onSideMenuClick(me.hoen.slidingmenu.MenuItem item){
    if(item.getLabel().equals(getString(R.string.first_menu_item))){
        //perform something, such as open a new fragment
    }
}
```


- Based on [shabbyowen/SlidingResideMenu](https://github.com/shabbyowen/SlidingResideMenu)
- [Demo](https://play.google.com/store/apps/details?id=me.hoen.slidingmenusample)
- [More information](https://anotherbullshitdayincodecity.wordpress.com/2015/08/29/android-sliding-menu-ios-reside-menu)
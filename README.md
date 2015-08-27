# Sliding Menu

## Install
Put library in the project root, in a folder named slidingmenu.

Add the following in settings.gradle
```
include ':slidingmenu'
```

Add the following in app/build.gradle
```
dependencies {
    compile project(':slidingmenu');
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
protected void goHome() {
    //do something, such as open home fragment, or do nothing.
}

/**
 * Returns an arraylist that will be used to display the side menu
 */
protected ArrayList<me.hoen.slidingmenu.MenuItem> getSlidingMenuItems(){
    final ArrayList<MenuItem> list = new ArrayList<>();

    list.add(new MenuItem(getString(R.string.first_menu_item)));

    return list;
}

/**
 * Will be called when a menu item is pressed
 */
protected void onSideMenuClick(me.hoen.slidingmenu.MenuItem item){
    if(item.getLabel().equals(getString(R.string.first_menu_item))){
        //perform something, such as open a new fragment
    }
}
```


Based on [shabbyowen/SlidingResideMenu](https://github.com/shabbyowen/SlidingResideMenu)
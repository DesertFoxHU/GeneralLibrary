[![](https://jitpack.io/v/DesertFoxHU/GeneralLibrary.svg)](https://jitpack.io/#DesertFoxHU/GeneralLibrary)

# GeneralLibrary

The library contains the following features:<br>
- Chance rolling
- Region picking like WorldEdit
- Region handling (Cuboid)
- Formatting doubles
- Converting Locations to readable string and vica-versa
- Serializator
- Inventory utilities (filling empty slots with items)
- Simple translation (doesn't support placeholders yet)
- ItemBuilder
- Invitation System
- Small Custom Block Framework


**About the library:**<br>

As the name suggest, the library contains basic things.<br>
The library was not made for complex systems, such as a full custom block framework, but this will change.<br>

Currently the library has a wide version range compatibility, due it's not using any specified NMS code.<br>
In the future the library most up-to-date features will only support the current minecraft version.<br>
If you need any other version you will need to do it yourself, you can freely fork this and make changes.<br>

# Installation
<details>
<summary>Maven</summary>

pom.xml:
```xml
<properties>
  <general.library>VERSION_NUMBER</general.library>
</properties>

<dependencies>
  <dependency>
    <groupId>com.github.DesertFoxHU</groupId>
    <artifactId>GeneralLibrary</artifactId>
    <version>${general.library}</version>
  </dependency>
</dependencies>
```
</details>

## Invitation System
The system is already included, but it's under testing.<br>
Documentation will be avaible after it's polished.<br>
See: `me.desertfox.gl.invitation` package

## Custom Block Framework
(Probably should not be called a framework)<br>
See: `me.desertfox.gl.custom.blocks` package<br>

## Timed Actions

![timedaction](https://user-images.githubusercontent.com/40893862/170261215-834a868f-7a8d-48ea-9038-e54796bbcd7d.png)

You can make cancellable countdown timers on a player's actionbar.

First you need to initialize to use this feature:
```java
import me.desertfox.gl.timedaction.TimedAction;

public class Main extends JavaPlugin {
  public void onEnable(){
    TimedAction.init(this);
  }
}
```

You need to extend `AbstractTimedAction`, which controls the logic of an action.
```java
public class TestAction extends AbstractTimedAction {

    @Override
    public void onCompleted(Player player){
        player.sendMessage("Completed!!");
    }
    
    //You can override a lot of thing, you can even change the basic color codes.
    @Override
    public void onTick(Player player, double remainingTime, double startDuration) {
        super.onTick(player, remainingTime, startDuration);
    }
    
    @Override
    public void onStart(Player player) {
        this.BRACKET_COLOR = "§8";
        this.TIME_COLOR = "§4";
    }

}
```

There is a sample to starting an action:
```java
public class Interact implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        if(e.getItem().getType() != Material.DIAMOND) return;

        TimedAction.startAction(e.getPlayer(), new TestAction(), 30);
    }
}
```

**Keep in mind a player only can have one TimedAction**<br>
So if you add an another with `startAction` the old one will be cancelled.<br>
Because of this you should make an event for ItemChange and cancel any going Action with `cancelAction(Player player)`

## Translation

Example can be found in `TranslationTest.java`<br>

## Suggestion: Manifold

Use manifold to be able to use the extension methods (InventoryExtensions, LocationExtensions), see: [Manifold](http://manifold.systems/)

## Future plans

* Support NMS things (NBTs) with multiple versions
* Better location save,load options (LocationUtils)
* LockPick system
* Submodule systems

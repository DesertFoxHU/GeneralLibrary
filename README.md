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

## Timed Actions

First you need to initialize to use this feature, like:
```java
import me.desertfox.gl.timedaction.TimedAction;

public class Main extends JavaPlugin {
  public void onEnable(){
    TimedAction.init(this);
  }
}
```

## Translation

Example can be found in `TranslationTest.java`<br>

## Maven

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

## Suggestion: Manifold

Use manifold to be able to use the extension methods (InventoryExtensions, LocationExtensions), see: [Manifold](http://manifold.systems/)

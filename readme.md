<h1>
  <img width="48" height="48" src="src/main/resources/assets/useful-glow-berries/icon.png" alt="" />
  Useful Glow Berries
</h1>

A Fabric Minecraft mod. Use glow berries in place of glow ink sacs on signs, or feed them to frogs to drop froglights when they eat slimes.

## Features

### Signs

<kbd>Right-click</kbd> a sign with a glow berry to make the text glow:

![A Minecraft screenshot of a spruce sign with glowing text being applied. A village is in the background, and the player is holding a glow berry, mid-swing. The sign's text says "useful glow berries!". A closed caption of the event is visible, saying "Glow Berry splotches."](.github/assets/sign.png)

### Froglights

Frogs fed glow berries will gain the Luck effect, changing the drop when they eat tiny slimes from slimeballs to froglights:

![A Minecraft screenshot of a frog being fed a glow berry by the player. Behind it is a swamp, with two other frogs in the middle of eating tiny slimes. Green effect particles emanate from the frogs. Multiple frog lights lay on the ground from previous drops.](.github/assets/frogs.png)

This effect lasts for five minutes, during which a frog can't be fed another glow berry. Froglight color drops match the [vanilla behavior](https://minecraft.wiki/w/Froglight#Mob_loot) of frog variants eating magma cubes.

I've intentionally implemented the effect as temporary to balance farmability. Fully-automatic froglight farms still require magma cubes.

## Server-side

This mod can function entirely server-side, but it adds a custom sound event that's needed on the client.

To install on your server without requiring users to download the mod, you can use something like [Polymer's AutoHost](https://polymer.pb4.eu/latest/user/resource-pack-hosting) to pack this mod's assets into a server resource pack. Polymer is supported automatically.

## Dependencies

- [Fabric Loader](https://fabricmc.net)
- [Fabric API](https://modrinth.com/mod/fabric-api)

## Installation

Jars are available on [Modrinth](https://modrinth.com/mod/useful-glow-berries) or [GitHub Releases](https://github.com/tommy-mitchell/useful-glow-berries/releases/latest).

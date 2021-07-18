# A library that observes your network status.
## Update in progress ...

[![](https://jitpack.io/v/MosesWangira/moses.altruism.network.svg)](https://jitpack.io/#MosesWangira/moses.altruism.network)

## Download 

### Using gradle
In your root build.gradle at the end of repositories add
```
allprojects {
 	repositories {
	...
	maven { url 'https://jitpack.io' }
	}
}
```

Add the dependency<br/>
Current Version is v1.0.0 (Make sure to check if its the current version)

```
dependencies {
    implementation 'com.github.MosesWangira:moses.altruism.network:v1.0.0'
}
```

### Using maven
Add the JitPack repository to your build file

```
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>
```

Add the dependency

```
dependency>
	<groupId>com.github.MosesWangira</groupId>
	<artifactId>moses.altruism.network</artifactId>
	<version>v1.0.0</version>
</dependency>
```

## How to use the library
extend AltruismNetwork() class<br/>
Example

```
class MainActivity : AltruismNetwork() {

}
```

Override the following functions to do what you want
onPositive - network active
onNegative - network inactive
Hint - You dont have to override this if you only want to observe the network status

```
  override fun onPositive() {
        super.onPositive()
       
    }
    
  override fun onNegative() {
        super.onNegative()
    }
```


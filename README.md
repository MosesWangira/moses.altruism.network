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
```
dependencies {
    implementation 'com.github.MosesWangira:moses.altruism.network:v1.0.2'
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
extend NetworkState() class //for activity<br/>
Example

```
class MainActivity : NetworkState() {

}
```

extend NetworkStates() class //for fragments<br/>
Example

```
class HomeFragment : NetworkStates() {

}
```

Override the following functions to do what you want<br/>
onPositive - network active <br/>
onNegative - network inactive <br/>

```
  override fun onPositive() {
        super.onPositive()
       
    }
    
  override fun onNegative() {
        super.onNegative()
    }
```


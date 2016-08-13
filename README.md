#Tabbels
![travis_ci](https://api.travis-ci.org/FireZenk/Tabbels.svg)

A crazy idea about bringing functional programming to Java, in an elegant way

Highly inspired by LUA tables, hence the play on the word Table to Tabbel; this is an attempt to represent this LUA Tables filled with pure functions, which can interact with the ecosystem without having to leave Java.

![tabbels_draft](https://cloud.githubusercontent.com/assets/1595403/17554914/9b90f8f4-5f0d-11e6-9721-7a1d3cbb13c5.png)

###GRADLE:
```groovy
	repositories {
	    	...
	    	maven { url 'https://github.com/FireZenk/maven-repo/raw/master/'}
	}
	dependencies {
			...
			compile 'org.firezenk:tabbels-core:1.0.0' // for java projects
	        compile 'org.firezenk:tabbels-android:1.0.0@aar' // for android projects
	}
```
###USAGE:

The simplest example in pure Java would be to create a function in a new table:
```java
    final Tabbels λλ = create(
    ).aλ(
    	"helloWorld", (self) -> {
        	System.out.println("Hello world!");
    }.build();
```
Here is another simple case for Android based projects:
```java
    // In your Application in order to observe the Activity lifecycle
    Tabbels.register(this);
```

```java
    // You need to cast core.Tabbels to android.Tabbels
    final Tabbels λλ = (Tabbels) create(
    ).aλ(
    	"onCreate", (self, bundle) -> {
        	setContentView(R.layout.main_activity);

        	final TextView tv = (TextView) findViewById(R.id.textView);
            	tv.setText("Hello world!");

        	return null;
    }.build();
```
Like a functional language, you can embed and combine functions using the variable `self`:
```java
    ...
    ).fλ(
    	"sum", (self, i1, i2) -> (Integer) i1 + (Integer) i2
    ).fλ(
    	"sum2", (self, i1, i2) -> self.fλ("sum", self.fλ("sum", 2, 4), 6)
    ).build();
```

###SOME IMPORTANT THINGS:

- Note the use of `fλ` or `aλ`, `fλ` is a function that returns something while `aλ` has no return value
- Remenber to call `build()` at the end of the declaration
- The implementation of Android is coupled with the life cycle of the activities (`Activity` only for now)

###MORE INFO:

	Go to sample module

###NEW ON LAST VERSION (1.1.0):

- Functions without return (like in rxjava) -> Actions, use them with `aλ`
- Old `λ` renamed to `fλ` to refrect the usage of Function instead of Action usage
- Removed rxjava dependecy
- Adds helper methods `isAction(String methodName)` and `isFunction(String methodName)`

###LICENSE

````
The MIT License (MIT)

Copyright (c) 2016 Jorge Garrido Oval <firezenk@gmail.com>

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
````

#Tabbels
[![Build Status](https://travis-ci.org/FireZenk/Tabbels.svg?branch=develop)](https://travis-ci.org/FireZenk/Tabbels) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Tabbels-green.svg?style=true)](https://android-arsenal.com/details/1/4128)

A crazy idea about bringing functional programming to Java, in an elegant way

Highly inspired by LUA tables, hence the play on the word Table to Tabbel; this is an attempt to represent this LUA Tables filled with pure functions, which can interact with the ecosystem without having to leave Java.

![tabbels_draft2](https://cloud.githubusercontent.com/assets/1595403/17645331/3b17aa2a-61a3-11e6-8b46-9e70c3e3ad59.png)

###GRADLE:
```groovy
	repositories {
	    	...
	    	maven { url 'https://github.com/FireZenk/maven-repo/raw/master/'}
	}
	dependencies {
			...
			compile 'org.firezenk:tabbels-core:{last_version}' // for java projects
	        compile 'org.firezenk:tabbels-android:{last_version}@aar' // for android projects
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
    final Tabbels λλ = create(
    ).aλ(
    	"onCreate", (self, bundle) -> {
        	setContentView(R.layout.main_activity);

        	final TextView tv = (TextView) findViewById(R.id.textView);
            tv.setText("Hello world!");
		}
    ).build();
```
Like a functional language, you can embed and combine functions using the variable `self`:
```java
    ...
  	...
    ).fλ(
    	"sum", (self, i1, i2) -> (Integer) i1 + (Integer) i2
    ).fλ(
    	"sum2", (self, i1, i2) -> self.fλ("sum", self.fλ("sum", 2, 4), 6)
    ).build();
```

###COMPOSITION:

Since version 1.3.0, Tabbels provides the possibility to compose tables from other tables. This is especially useful for applying design patterns in the presentation layer and enhance the functionality of our classes from other, simulating multiple inheritance :

```java
  ...
	).inject(
        new SomePresenter().λλ, new ColorHelper().λλ
    ).build();
```

###SOME IMPORTANT THINGS:

- Note the use of `fλ` or `aλ`, `fλ` is a function that returns something while `aλ` has no return value
- Remember to call `build()` at the end of the declaration
- The implementation of Android is coupled with the life cycle of the activities (`Activity` only for now)

###MORE INFO:

	Go to sample module

###NEW ON LAST VERSION (1.3.0):

- Interconnect _Tabbels_ using `inject(Tabbels... dependency)`

###MORE VERSION CHANGES:

- [See CHANGES.md](https://github.com/FireZenk/Tabbels/blob/develop/CHANGES.md)

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

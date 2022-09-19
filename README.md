# Overview

It is a simple maven application in which there is a bug on JD-GUI when it attempts to decompile .jar file.
There are two classes which are both `Message` as name but in separated package. The one is put in `package_1` and the second in `package_2`.
In the `Main` class we create two variables from these both class and use them.

# Context

Tested on JD-GUI `v1.6.6`

# Expected result

When we create the .jar file from `mvn clean package` and open the .jar file in `target` directory using JD-GUI we should get the following content in Main class.

```java
package org.example;

public class Main {
    public static void main(String[] args) {
        org.example.package_1.Message messageFromPackageOne = new Message("Message from package one");
        System.out.println(messageFromPackageOne.getMessage());
        org.example.package_2.Message messageFromPackageTwo = new Message("Message from package two");
        System.out.println(messageFromPackageTwo.getMessage());
    }
}
```

# Actual result

But we get :

```java
package org.example;

import org.example.package_1.Message;
import org.example.package_2.Message;

public class Main {
  public static void main(String[] args) {
    Message messageFromPackageOne = new Message("Message from package one");
    System.out.println(messageFromPackageOne.getMessage());
    Message messageFromPackageTwo = new Message("Message from package two");
    System.out.println(messageFromPackageTwo.getMessage());
  }
}
```

And in this result, we get conflict `Message` class. We don't know anymore if it belongs to `org.example.package_1` or `org.example.package_2`.
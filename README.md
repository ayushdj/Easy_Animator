# Easy_Animator

## Overview: 

This project combines 2D shapes and animation to create something visually appealing. It allows for users to add shapes and edit the animation with respect to shape position, shape color and shape size. The project was completed in a group of three for the CS 5004 class at Northeastern University. 

## Model Design Choices and Decisions: 

The project consists of: 

* **Interfaces** 

  * IShape 

  * AnimationChanges 

  * EasyAnimatorModel 

* **Classes** 

   * AbstractShape (abstract class implements IShape) 

   * Rectangle (extends Abstract Shape) 

   * Oval (extends Abstract Shape) 

  * MoveShape (implements AnimationChanges) 

  * ChangeColor (implements AnimationChanges) 

  * ScaleShape (implements AnimationChanges) 

  * EasyAnimatorModel (implements EasyAnimatorModel) 
  

#### IShape:

This interface defines the methods that are going to be implemented on different shapes. It consists mainly of a constructor, getter and setter methods. 

#### AbstractShape (implements IShape): 

The AbstractShape class was created to reduce duplication of variables and functions that would be used by both the Rectangle and Oval classes. It implements most of the methods outlined in IShape. However, methods such as `getPerimeter()` and `getArea()` amongst others, are implemented in the classes that extended AbstractShape. 

#### Rectangle (extends AbstractShape):

This class represents the Rectangle shape. It extends the class AbstractShape because a lot of 
its methods and fields are common to all shapes. Rectangle also contains a `toString()` method that displays its original state. 

#### Oval (extends AbstractShape):

This class represents the Oval shape. It extends the class AbstractShape because a lot of 
its methods and fields are common to all shapes. Oval also contains a `toString()` method that displays its original state. 

#### AnimationChanges:

This interface defines the methods that change the state of an IShape object. This interface 
will be implemented by class that represent the changes. We felt that this interface was required since classes that mutate the fields of IShape Objects share a lot of commonalities.  
Any class that implements this interface will also have an added "tweening" method, that allows 
us to make changes per "tick" in the animation (if the user selects a visual view).

#### MoveShape (implements AnimationChanges):

This class represents the changes to the IShape Objects (x,y) position. It allows the user to move the 
IShape object from its current position to the new position on the 2D plane. 

#### ChangeColor (implements AnimationChanges): 

This class represents the changes to the IShape Object's color. It allows the user to change a shape’s color to any within the RGB spectrum.  

#### ScaleShape (implements AnimationChanges):

This class represents the changes to the IShape Object's size. It allows the user to resize the shape to either a custom length and width or scale the Object using a scale factor. This class involves overloading of constructors. 

#### EasyAnimatorModel: 

This interface was created in order to allow easy testing of our controller. It also hides the implementation of the Model from the clients. 

#### EasyAnimatorModelImpl (implements EasyAnimatorModel): 

This class serves as the Model class of our animation. The class is responsible for implementing the logic 
that updates the state of objects to eventually pass that information to the controller. The inputs from the controller will call methods in this class to update/mutate our shape objects. The class also allows for the addition and removal of shapes from the animation.

The class utilizes two types of data structures namely, an `ArrayList<IShape>` and a `HashMap<String,AnimationChanges>`. The ArrayList is responsible for storing original states of all shapes present in the animation, while the HashMap stores the mutations that have taken place to each shape. The keys of the hashmap are the String names of the IShape objects, and the values are an `ArrayList<AnimationChanges`. The ArrayList stores a clone of the original shape Objects.

We used an implementation of Java's List interface because they are dynamic in nature. This is because an animation can have multiple shapes within a certain time period. Therefore, we can add and remove shapes as we please to the ArrayList. This would have been a much harder process had we used a traditional 2D array. 

The reason we went with a HashMap as our primary data structure is because each name associated with each shape is unique. The name of the shape can also be used to identify all the modifications made to that particular shape. Therefore we used a HashMap, due to the "unique" nature of Key/Value pairs.

The class contains a `toString()` method that when called returns a textual representation of the animation. 

#### Further Design Choices:
We chose to represent mutations such as moving, changing scale, changing color as their own objects to make our design more modular. This decision allows each `MoveShape`, `ScaleShape`, `ChangeColor`to represent their changes in their own `toString()` method. Furthermore, if we needed to add more changes to the obects, we can just create more classes that implement the `AnimationChanges` interface. This eliminates the need to edit the existing code. 




## View Design Choices and Decisions:

The view consists of: 

* **Interfaces**

  * IView

* **Classes**
  
  * SvgView (implements IView)
  * TextView (implements IView)
  * VisualView (implements IView, has a JFrame and JPanel)
    * SwingFrame (extends JFrame)
    * SwingPanel (extends JPanel)
  * EasyAnimator (parses the file name passed in from the command line and determines what
    type of view the user wants, the name of the output file, populates the data structures
     in the model and determines the speed of the animation. Also handles exceptional 
    situations based on the command-line input. Passes on the parsed information to the ViewFactory)
  * ViewFactory (determines what kind of view to produce based on user input that was passed to it
    from the EasyAnimator class)
    
N.B. The model's data structures are populated through the use of the AnimationBuilder, whose
implementation exists as a static class in the EasyAnimatorModelImpl class.

### Text View: ### 

The text view allows the user to: 

* View a full description of the original states of the shapes that are present in the animation. 

* View all the changes made to every shape present in the animation. 

* View changes made to a specific shape present in the animation. 

### SVG View: ###

The SVG view allows us to render the model in SVG format such that the animation can be viewed
in other applications, such as a browser. It allows the same abilities as the text view, except that
the animation is represented in svg/xml format. The SVG view is built using a string builder, which 
is then returned to the ViewFactory that outputs that string into a file.

### Visual View: ###

The Visual view allows a user to visualize in real time the animation that they passed into the 
AnimationReader. 

The visual view uses the Java JFrame and JPanel classes respectively to show the animation to the 
user. The JFrame also has the ability to scroll if the size of the canvas is not optimal. The JFrame 
uses composition to have a JPanel, and the JPanel is responsible for drawing a set of mutated 
shapes at a particular time stamp (i.e. the current tick). The list of mutated shapes are given

## Overview of Run Design: 

1. The user passes in a text file representing an animation.
2. The text file, along with any other command line arguments are passed into the EasyAnimator class.
   - Data structures in the model are populated based on the text file going into the AnimationReader.
     (They are populated through the use of the builder in the EasyAnimatorModelImpl class).
   - The type of view, output file name, and the speed of the animation are also determined.
3. We pass along the new "filled" model, the speed, the type of view, and the output file name to
   the ViewFactory class.
4. Based on the view type passed into it from EasyAnimator, an 
   instance of the appropriate IView subtype is created, and the view is generated.

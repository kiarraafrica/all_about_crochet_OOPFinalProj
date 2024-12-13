<p align="center">
  <img src="gif.gif" width="800" height="auto">
</p>


Welcome to **All 'bout Crochet**!

*This java-project tailored for crochet enthusiast, is designed to offer comprehensive description of crochet tools, yarns, different stitches, and helpful tips & tricks. It also includes a personalized suggestion that features to inspire users with color options and project ideas. To spice things up, users can maintain their personal yarn stash to organize their yarns.*

## I. Features:
- **Yarn Stash**: Organize and maintain your personal yarn stash.
- **Crochet Tools**: Detailed desciptions of tools used in crocheting.
- **Yarns**: Information about different types of yarn, their descriptions, and preferred hook size.
- **Stitches**: Learn various crochet stitches and techniques.
- **Tips & Tricks**: Get useful advice to enhance your crocheting skills.
- **Suggesters**: Receive inspiration with color options and project ideas.

## II. OOP Principles:
1. **Encapsulation**
    - In the UserManager class, sensitive data like userData is private, and methods such as setUsernameInput(), setPasswordInput(), and saveUser() ensure secure interaction. Similarly, the YarnStash class controls access to yarn stash information with methods like addYarn(), removeYarn(), and editStash(), keeping the internal structure hidden. The Tool, Yarn, Stitch, and Tips classes also encapsulate their attributes, providing public getter methods for access.
2. **Abstraction**
    -  The abstract class Suggester2 defines a blueprint for subclasses like ColorSuggester and ProjectSuggester, which implement the getSuggestion() method. The YarnStash class abstracts yarn management, offering simple methods for user interaction, while the AboutCrochet class organizes the Tool, Yarn, Stitch, and Tips classes into intuitive menus and methods.
3. **Inheritance**
    - The Suggester2 class serves as a base for ColorSuggester and ProjectSuggester, while initializers like ToolInitializer, YarnInitializer, StitchInitializer, and TipsInitializer extend functionality, creating collections for easy access.
4. **Polymorphism**
    - The Suggester class dynamically handles subclasses like ColorSuggester and ProjectSuggester, each overriding getSuggestion(). The AboutCrochet class uses polymorphism to process objects like Tool, Yarn, Stitch, and Tips generically while preserving their specific behaviors.

## III. Sustainable Development Goal (SDG):
- **SDG 4: Quality Education**
    1. *Promotes Skill Development*
        - This project provides education resources about crochet, such as tools, yarnology, stitch libraries, and tips & tricks. These features encourages users to develop a tangible, creative skill that fosters personal growth and creativity.
    2. *Support Lifelong Learner*
        - Crochet, as an activity, is suitable for all ages, making it a lifelong learning opportunity. Whether the users are beginners or advanced crafters, they can continuously expand their skills with the project's tools like tutorials and project suggestions.
    3. *Accessible Education*
        - By presenting crochet tools, techniques, and ideas in a clear, engaging way, the project makes education accessible to individuals who might not have formal instruction in crafting.

## IV. Instruction
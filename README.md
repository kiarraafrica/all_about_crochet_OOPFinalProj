![Alt text](gif.gif)

## Table of Contents:
    📍Overview of the Project
    📍OOP Principles
    📍Sustainable Development Goal (SDG)
    📍Instruction for Running the Program

## Overview of the Project
*This java-project tailored for crochet enthusiast, is designed to offer comprehensive description of crochet tools, yarns, different stitches, and helpful tips & tricks. It also includes a personalized suggestion that features to inspire users with color options and project ideas. To spice things up, users can maintain their personal yarn stash to organize their yarns.*

## OOP Principles
1. **Encapsulation**
    - 🔒Encapsulation is achieved by keeping the attributes of the Tool, Yarn, Stitch, and Tips classes private and exposing them through public getter methods. For example, in the Tool class, attributes like name and description are private, and methods like getName() and getDescription() provide controlled access. Similarly, the Yarn, Stitch, and Tips classes use private attributes such as name, description, and hookSize to store their data. This approach ensures that the internal state of these classes is protected and only accessible through well-defined methods.
2. **Abstraction**
    - 🎭Abstraction is implemented through the use of abstract classes like Suggester2. This abstract class provides a high-level blueprint for different types of suggesters, hiding the underlying complexity of specific implementations like ColorSuggester and ProjectSuggester from the user.
3. **Inheritance**
    - 🧬The project leverages inheritance to promote code reuse. For instance, in the Suggester class, the ColorSuggester and ProjectSuggester classes inherit from the abstract Suggester2 class, enabling specific implementations of the getSuggestion method while sharing common functionality.
4. **Polymorphism**
    - 🔄Polymorphism is demonstrated through method overriding. The getSuggestion method in the Suggester2 class is overridden by ColorSuggester and ProjectSuggester to provide specialized behavior based on the object type at runtime. This allows for dynamic method dispatch during execution.

## Sustainable Development Goal (SDG)
- **SDG 4: Quality Education**
    1. *Promotes Skill Development*
        - 🎓This project provides education resources about crochet, such as tools, yarnology, stitch libraries, and tips & tricks. These features encourages users to develop a tangible, creative skill that fosters personal growth and creativity.
    2. *Support Lifelong Learner*
        - 🌟Crochet, as an activity, is suitable for all ages, making it a lifelong learning opportunity. Whether the users are beginners or advanced crafters, they can continuously expand their skills with the project's tools like tutorials and project suggestions.
    3. *Accessible Education*
        - 🌐By presenting crochet tools, techniques, and ideas in a clear, engaging way, the project makes education accessible to individuals who might not have formal instruction in crafting.

## Instruction for Running the Program
1. Main Menu
    - 📝Sign up: If you do not have an account
    - 🔑Log in: Access your account
2. Crochet Menu
    - Yarn Stash
        - 👀View: See all yarns in your stash or be notified if it's empty
        - ➕Add: Add yarn details, including type, color, and weight
        - ✏️Edit: Update the information of a specific yarn
        - 🗑️Remove: Delete yarn from your stash
    - About Crochet Menu
        - 🛠️Crochet Tools: Descriptions of essential crochet tools
        - 🧵Yarnology: Explore different yarn types and their characteristics
        - 📖Stitch Library: Tutorials for a variety of stitches
        - 💡Tips and Tricks: Helpful advice to improve your crocheting skills
    - Suggester
        - 🎨Palette Picker: Generate 1-color, 2-color, or 5-color palettes
        - 🪡Project Ideas Generator: Receive suggestions for simple or big projects, with design ideas
3. Log out

## About the Developer
- Kiarra Francecsa Gabrielle S. Africa

- COURSE:
    - CS 211 (Object-Oriented Programming)
- COURSE FACILITATOR:
    - Ms. Fatima Marie Agdon, MSCS
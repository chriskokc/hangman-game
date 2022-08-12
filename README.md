# Hangman game
## Project idea
  -  This project is built in Java using the concept of OOP.
  - Inspired by the MVC design pattern, the game was separated into different classes:
    - Model i.e Game logic
    - View i.e view.InputDisplay 
    - Controller i.e controller.Mediator


### Flowchart
  ![Hangman game flowchart drawio](https://user-images.githubusercontent.com/87203804/183292169-83aa2b2f-5642-498d-824e-b217430708d0.png)

    
### Classes
  - Game Logic
    - Variables
      - default user's life
      - list of words
    
    - Play game
      - pick a random word from list of words
      - while (random word still has char AND user's life > 0):
        - obtains user's input
        - check if the random word includes the user's input char
            - if yes: remove that char in random word
            - otherwise: subtract user's life by 1
    
    - Decide win or lose
      - if user's life <= 0: 
        - user loses
      - else: user wins
      - reset user's life


  - view.InputDisplay
    - Variables
      - beginning: inputDisplay a number of _ based on the length of random word
      - user's life
    
    - Play game
      - if user picks char correctly:
        - replace _ with that char
      - otherwise:
        - adding graphics
        - subtract user's life by 1 
      
    - Decide win or lose
      - Give feedback to user based on state 


  - controller.Mediator
    - getting user's input and sends it to Game Logic
    - Game Logic handles user's input
    - Game Logic sends interpretation to controller.Mediator
    - controller.Mediator sens interpretation to view.InputDisplay
    - view.InputDisplay shows interpretation to user



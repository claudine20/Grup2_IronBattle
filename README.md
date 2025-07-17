Howdy?!

This program is a text-based RPG where Warriors and Wizards face off in duels.

Features:

- Turn-based combat system
- Create characters (Warriors or Wizards) with randomized stats and abilities
- Battle logging and winner announcement


Class Structure:

- BattleSimulator: Main class that handles user interaction and battle logic
- Character: Abstract base class for all character types
- Warrior: Character that attacks using strength and stamina
- Wizard: Character that casts spells using intelligence and mana
- Attacker: Interface implemented by all classes that can attack

  
Game Rules:

- Warriors have 100-200 HP, 10-50 stamina, and 1-10 strength
- Wizards have 50-100 HP, 10-50 mana, and 1-50 intelligence
- Both characters attack simultaneously each round
- Battle continues until at least one character is defeated
- In case of a tie, the battle restarts with new HP

Implementation Notes:

- Character created as an abstract class so it can be extended by Warrior and Wizard classes
- HP is never allowed to drop below zero, characters die at 0 HP
- Each character gets a unique randomly-generated 4-digit ID 
- Both characters can attack in the same round, allowing for possible tie scenarios
- Added input validation to prevent errors and improve user experience
- Warriors and Wizards manage different combat resources (stamina vs mana) when attacking

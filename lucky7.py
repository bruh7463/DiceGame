from random import randint

class Die():
	def __init__(self, num_faces):
		self.num_faces = num_faces
		self.faceValue = 0

	def roll(self):
		self.faceValue = randint(1, self.num_faces)

	def getFaceValue(self):
		return self.faceValue

class Person():
	def __init__(self):
		self.die1 = Die(6)
		self.die2 = Die(6)

	def throwDie(self):
		self.die1.roll()
		self.die2.roll()

		print(self.die1.getFaceValue())
		print(self.die2.getFaceValue())

class DiceGame():
	def __init__(self, winningNum):
		self.winningNum = winningNum
		self.player = Person()

	def play(self):
		game = True

		while (game):
			try:
				status = int(input("Enter 1 to play or 0 to quit: "))

				if (status == 0):
					game = False
				elif (status == 1):
					self.player.throwDie()

					if ((self.player.die1.getFaceValue() + self.player.die2.getFaceValue() == self.winningNum)):
						print("Congratulations!!!!")
					else:
						print("Sorry you lose!!!!")
				else:
					print("Wrong input....")
			except ValueError:
				print("Wrong input....")
try:
	print("Welcome to the Lucky 7 game!!!!")
	print("""
						       .-------.    _______
						      /   o   /|   /\\      \\
						     /_______/o|  /o \\  o   \\
						     | o     | | /   o\\______\\
						     |   o   |o/ \\o   / o    /
						     |     o |/   \\o /   o  /
						     '-------'     \\/_____o/
		""")

	game = DiceGame(7)
	game.play()
except KeyboardInterrupt:
	print("\nWhoops......")
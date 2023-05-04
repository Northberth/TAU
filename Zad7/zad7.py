import random

board = [' ' for x in range(56)]
field = 0
def print_board(board):
	print(board[11], ' |', board[12], ' |', board[13], ' |', board[14], ' |', board[15])
	print('--', '+', '--', '+', '--', '+', '--', '+', '--')
	print(board[21], ' |', board[22], ' |', board[23], ' |', board[24], ' |', board[25])
	print('--', '+', '--', '+', '--', '+', '--', '+', '--')
	print(board[31], ' |', board[32], ' |', board[33], ' |', board[34], ' |', board[35])
	print('--', '+', '--', '+', '--', '+', '--', '+', '--')
	print(board[41], ' |', board[42], ' |', board[43], ' |', board[44], ' |', board[45])
	print('--', '+', '--', '+', '--', '+', '--', '+', '--')
	print(board[51], ' |', board[52], ' |', board[53], ' |', board[54], ' |', board[55])

def main():
	start = random.randrange(11, 15)
	global field
	field = start
	end = random.randrange(51, 55)
	for i in range(2,5):
		obstacle = random.randrange(i*10 + 1, i*10 + 5)
		board[obstacle] = "X"
	board[start] = "A"
	board[end] = "B"
	print_board(board)
	print("\n")
	i = 0
	while i<10:
		move()
def move():
	try:
		global field
		print(field)
		move = input("Podaj ruch: Numer wiersza/ Numer kolumny, A - start, B - koniec\n")
		if board[availableMove(move)] == ' ':
			board[availableMove(move)] = "P"
			field = availableMove(move)
			print(field)
		else:
			print("Ruch niedozwolony\n")
		print_board(board)
		print("\n")
	except ValueError:
		print("Nieprawidłowy wpis. Podaj intową liczbę\n")

def availableMove(move):
	global field
	if move == "up":
		return field-10
	elif move == "down":
		return field+10
	elif move == "right":
		return field+1
	elif move == "left":
		return field-1
	else:
		return field
main()
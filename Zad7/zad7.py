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
	i = 1
	while i>0:
		i = move()
def move():
	try:
		global field
		print(field)
		move = input("Podaj ruch: up - ruch w górę, down - ruch w dół, left - ruch w lewo, right - ruch w prawo\n A - start, B - koniec, X - przeszkoda, P - gracz\n")
		if board[availableMove(move)] == ' ':
			board[availableMove(move)] = "P"
			field = availableMove(move)
			print(field)
		elif board[availableMove(move)] == 'B':
			print("Wygrałeś!")
			return 0
		else:
			print("Ruch niedozwolony\n")
		print_board(board)
		print("\n")
		return 1
	except ValueError:
		print("Nieprawidłowy wpis. Podaj intową liczbę\n")

def availableMove(move):
	global field
	if move == "up":
		if field-10 > 11:
			if board[field] == "P":
				board[field] = " "
			return field-10
	elif move == "down":
		if field+10 < 56:
			if board[field] == "P":
				board[field] = " "
			return field+10
	elif move == "right":
		if (field + 1) % 10 < 6:
			if board[field] == "P":
				board[field] = " "
			return field+1
	elif move == "left":
		if (field-1) % 10 != 0:
			if board[field] == "P":
				board[field] = " "
			return field-1
	return field

main()
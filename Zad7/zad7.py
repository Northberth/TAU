import random
import pytest

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
		move = input("Podaj ruch: up - ruch w górę, down - ruch w dół, left - ruch w lewo, right - ruch w prawo\n A - start, B - koniec, X - przeszkoda, P - gracz\n")
		return move_validation(move)
	except ValueError:
		print("Nieprawidłowy wpis. Podaj up, down, left lub right\n")

def move_validation(move):
	global field
	if board[available_move(move)] == ' ':
		board[available_move(move)] = "P"
		field = available_move(move)
		print(field)
	elif board[available_move(move)] == 'B':
		print("Wygrałeś!")
		return 0
	else:
		print("Ruch niedozwolony\n")
		return 2
	print_board(board)
	print("\n")
	return 1

def available_move(move):
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

def static_board():
	board[12] = "A"
	board[54] = "B"
	board[24] = "X"
	board[32] = "X"
	board[43] = "X"

#main()

right_fields = [15,25,35,45,55]
left_fields = [11,21,31,41,51]
top_fields = [11,12,13,14,15]
bottom_fields = [51,52,53,54,55]

@pytest.mark.parametrize("actual_fields_right", right_fields)
def test_right_border(actual_fields_right):
	global field
	field = actual_fields_right
	board[field] = "P"
	assert available_move("right") == field

@pytest.mark.parametrize("actual_fields_left", left_fields)
def test_left_border(actual_fields_left):
	global field
	field = actual_fields_left
	board[field] = "P"
	assert available_move("left") == field

@pytest.mark.parametrize("actual_fields_top", top_fields)
def test_top_border(actual_fields_top):
	global field
	field = actual_fields_top
	board[field] = "P"
	assert available_move("up") == field

@pytest.mark.parametrize("actual_fields_bottom", bottom_fields)
def test_bottom_border(actual_fields_bottom):
	global field
	field = actual_fields_bottom
	board[field] = "P"
	assert available_move("down") == field

def test_win():
	static_board()
	global field
	field = 53
	assert move_validation("right") == 0
	field = 55
	assert move_validation("left") == 0
	field = 44
	assert move_validation("down") == 0

def test_obstacle_four_directions():
	static_board()
	global field
	field = 23
	assert move_validation("right") == 2
	field = 25
	assert move_validation("left") == 2
	field = 34
	assert move_validation("up") == 2
	field = 14
	assert move_validation("down") == 2



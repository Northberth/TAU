board = [' ' for x in range(26)]
def print_board(board):
	print(board[1], ' |', board[2], ' |', board[3], ' |', board[4], ' |', board[5])
	print('--', '+', '--', '+', '--', '+', '--', '+', '--')
	print(board[6], ' |', board[7], ' |', board[8], ' |', board[9], ' |', board[10])
	print('--', '+', '--', '+', '--', '+', '--', '+', '--')
	print(board[11], ' |', board[12], ' |', board[13], ' |', board[14], ' |', board[15])
	print('--', '+', '--', '+', '--', '+', '--', '+', '--')
	print(board[16], ' |', board[17], ' |', board[18], ' |', board[19], ' |', board[20])
	print('--', '+', '--', '+', '--', '+', '--', '+', '--')
	print(board[21], ' |', board[22], ' |', board[23], ' |', board[24], ' |', board[25])

def main():
	print_board(board)
	print("\n")

main()
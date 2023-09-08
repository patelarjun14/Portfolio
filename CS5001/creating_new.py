'''
Arjun Patel
CS5001 FallTWO021
Final Project
'''
import turtle
import random

NUM_SQUARES = 8
SQUARE_SIZE = 50
COLOR_LIGHT_GRAY = 'light gray'
COLOR_WHITE = 'white'
COLOR_RED = 'red'
COLOR_GREEN = 'green'
COLOR_PINK = 'pink'
COLOR_GREY = 'grey'
COLOR_BLACK = 'black'
COLOR_YELLOW = 'yellow'
PEN = turtle.Turtle()

RIGHT_ANGLE = 90
SQUARE_SIDES = 4
CIRCLE_SIZE = 25

BLACK = 0
RED = 1
EMPTY = '_'

SELECTED = "selected"
AVAILABLE = "available"
CAPTURE = "capture"

KING = 'king'
BLACK_KING = "King0"
RED_KING = "King1"

def Draw_Square(size):
        PEN.begin_fill()
        PEN.pendown()
        for i in range(SQUARE_SIDES):
            PEN.forward(size)
            PEN.left(RIGHT_ANGLE)
        PEN.end_fill()
        PEN.penup()

def Draw_Circle(out_color,in_color,a_turtle,corner,x,y):
    a_turtle.color(out_color, in_color)
    a_turtle.setposition(corner + SQUARE_SIZE * x, corner + SQUARE_SIZE * y)
    a_turtle.forward(CIRCLE_SIZE)
    a_turtle.begin_fill()
    a_turtle.pendown()
    a_turtle.circle(CIRCLE_SIZE)
    a_turtle.end_fill()
    a_turtle.penup()

class Board:

    def __init__(self):
        self.board_size = NUM_SQUARES * SQUARE_SIZE
        self.window_size = self.board_size + SQUARE_SIZE
    

    def Create_Board(self):
        turtle.setup(self.window_size, self.window_size)
        turtle.screensize(self.board_size,self.board_size)
        turtle.bgcolor(COLOR_WHITE)
        turtle.tracer(0,0)

        ###################################################################
        corner = -self.board_size / 2-1
        PEN.setposition(corner,corner)
        Draw_Square(self.board_size)
        PEN.penup()
        PEN.hideturtle()
        PEN.color(COLOR_BLACK,COLOR_WHITE)
        PEN.setposition(corner,corner)
        ###################################################################

        PEN.color(COLOR_BLACK, COLOR_LIGHT_GRAY)
        for col in range(NUM_SQUARES):
            for row in range(NUM_SQUARES):
                PEN.setposition(corner + SQUARE_SIZE * col, corner + SQUARE_SIZE * row)
                if col % 2 != row % 2:
                    Draw_Square(SQUARE_SIZE)

class Pieces:

    def __init__(self,color):
        self.color = color
        self.selected = False
        self.stage = 'regular'
        self.taken = False

        if color == COLOR_BLACK:
            self.value = BLACK
        if color == COLOR_RED:
            self.value = RED
        if color == EMPTY:
            self.value = EMPTY


    def Draw_Piece(self,a_turtle,x,y):

        board_size = NUM_SQUARES * SQUARE_SIZE
        corner = -board_size / 2 - 1

        # If the piece is selected, we need it to turn green
        if self.selected == True:
            Draw_Circle(COLOR_GREEN,self.color,a_turtle,corner,x,y)

        # If the piece is black or red, lets draw it
        if (self.value == 0 or self.value == 1) and self.selected == False:
            Draw_Circle(COLOR_BLACK,self.color,a_turtle,corner,x,y)

        if self.stage == KING:
            Draw_Circle(COLOR_YELLOW,self.color,a_turtle,corner,x,y)
        
        # If the piece is taken, we need to highlight it as yellow
        if self.taken == True:
            Draw_Circle(COLOR_BLACK, COLOR_YELLOW,a_turtle,corner,x,y)

        # If the piece is empty is on a grey square, we need to draw the square
        if (self.value == '_') and (x % 2 != y % 2) and self.taken == False:
            a_turtle.color(COLOR_BLACK, COLOR_LIGHT_GRAY)
            a_turtle.setposition(corner + SQUARE_SIZE * x, corner + SQUARE_SIZE * y)
            Draw_Square(SQUARE_SIZE)

class Square():

    def __init__(self,piece):
        self.avaliable = False
        self.piece = piece

    def Draw_Square_State(self,a_turtle,x,y):
        board_size = NUM_SQUARES * SQUARE_SIZE
        corner = -board_size / 2 - 1

        if self.avaliable == True:
            Draw_Circle(COLOR_BLACK,COLOR_GREEN,a_turtle,corner,x,y)

        if self.avaliable == False:
            self.piece.Draw_Piece(PEN,x,y)

        
class Action():

    def __init__(self):
        self.x = 0
        self.y = 0
        self.save_last_click_x = 0
        self.save_last_click_y = 0

        

class GameState():
    def __init__(self):
        self.gamestate = [['_']*8,['_']*8,['_']*8,['_']*8,['_']*8,['_']*8,['_']*8,['_']*8,]
        self.moves = 1
        self.turn = 'black'
        self.move_taken = False
        self.end_game = False

    def check_end_game(self):
        black_count = 0
        red_count = 0
        for col in range(NUM_SQUARES):
            for row in range(NUM_SQUARES):
                if self.gamestate[col][row].piece.value == 0:
                    black_count += 1
                if self.gamestate[col][row].piece.value == 1:
                    red_count += 1
        if black_count == 0:
            self.end_game = True
            print("OH NO! RED WINS!")
            print("CONGRATS! BLACK WINS!")
            return True
        if red_count == 0:
            self.end_game = True
            print("CONGRATS! BLACK WINS!")
            return True


    def Create_GameState(self,board_size):
        for col in range(NUM_SQUARES):
            for row in range(NUM_SQUARES):
                if (col % 2 != row % 2) and (row > 4):
                    self.gamestate[col][row]= Square(Pieces('red'))
                else:
                    self.gamestate[col][row] = Square(Pieces('_'))

        for col in range(NUM_SQUARES):
            for row in range(NUM_SQUARES):       
                if (col % 2 != row % 2) and (row < 3):
                    self.gamestate[col][row]= Square(Pieces('black'))


    

    def print_board(self):
        line_value = []
        print('Columns: ', '0', '   1', '   2', '   3', '   4', '   5', '   6', '   7')
        for row in range(7,-1,-1):
            for col in range(8):
                if self.gamestate[col][row].piece != '_':
                    line_value.append('' + str(self.gamestate[col][row].piece.value) + '')
                if self.gamestate[col][row].piece == '_':
                    line_value.append(self.gamestate[col][row].piece)
            print('Row: ', row, line_value)
            line_value = []
        print('__________________________________________')
        print('__________________________________________')


    def change_turn(self, count):
        if self.turn % 2 == 0:
            self.turn = COLOR_BLACK
            print("Its Black's Move")
        if self.turn % 2 == 1:
            self.turn = COLOR_RED
            print("Its Red's Move")

        
    def Update_GameState(self):
        for col in range(NUM_SQUARES):
            for row in range(NUM_SQUARES):
                self.gamestate[col][row].Draw_Square_State(PEN,col,row)


    def Clean_Avaliable(self):
        for col in range(NUM_SQUARES):
            for row in range(NUM_SQUARES):
                self.gamestate[col][row].avaliable = False
                self.gamestate[col][row].piece.selected = False
                self.gamestate[col][row].piece.taken = False
                if self.gamestate[col][row].piece.value == 'X' and self.gamestate[col][row].piece.color == 'red':
                    self.gamestate[col][row].piece.value = 1

                if self.gamestate[col][row].piece.value == 'X' and self.gamestate[col][row].piece.color == 'black':
                    self.gamestate[col][row].piece.value = 0

                if row == 0 and self.gamestate[col][row].piece.color == 'red':
                    self.gamestate[col][row].piece.stage = KING
                
                if row == 7 and self.gamestate[col][row].piece.color == 'black':
                    self.gamestate[col][row].piece.stage = KING

    def remove_piece(self,x,y):
        if x != 7 and y != 7:
            if self.gamestate[x+1][y+1].piece.taken == True:
                self.gamestate[x+1][y+1]=Square(Pieces('_'))
                self.move_taken = True

        if x != 7 and y != 0:
            if self.gamestate[x+1][y-1].piece.taken == True:
                self.gamestate[x+1][y-1]=Square(Pieces('_'))
                self.move_taken = True

        if x != 0 and y != 7:
            if self.gamestate[x-1][y+1].piece.taken == True:
                self.gamestate[x-1][y+1]=Square(Pieces('_'))
                self.move_taken = True
                
        if x != 0 and y != 0:
            if self.gamestate[x-1][y-1].piece.taken == True:
                self.gamestate[x-1][y-1]=Square(Pieces('_'))
                self.move_taken = True



    def take_move(self,x,y):
        
        if (self.gamestate[x][y].piece.color == 'black' and 
        (x != 7 and x != 6) and (y != 7 and y != 6) and 
        (self.gamestate[x+1][y+1].piece.color == 'red' and 
        self.gamestate[x+2][y+2].piece.value == '_')):
            self.gamestate[x+2][y+2].avaliable = True
            self.gamestate[x+1][y+1].piece.taken = True
            self.gamestate[x+1][y+1].piece.value = 'X'



        # Include Special case
        if (self.gamestate[x][y].piece.color == 'black' and 
        (x != 0 and x !=1) and (y != 7 and y != 6) and 
        (self.gamestate[x-1][y+1].piece.color == 'red' and 
        self.gamestate[x-2][y+2].piece.value == '_')):

            self.gamestate[x-2][y+2].avaliable = True

            self.gamestate[x-1][y+1].piece.taken = True
            self.gamestate[x-1][y+1].piece.value = 'X'
            
        # lower right
        if (self.gamestate[x][y].piece.color == 'black' and 
        (x != 7 and x != 6) and (y != 0 and y != 0) and self.gamestate[x][y].piece.stage == KING and 
        (self.gamestate[x+1][y-1].piece.color == 'red' and
        self.gamestate[x+2][y-2].piece.value == '_')):

            self.gamestate[x+2][y-2].avaliable = True

            self.gamestate[x+1][y-1].piece.taken = True
            self.gamestate[x+1][y-1].piece.value = 'X'

        # lower left
        if (self.gamestate[x][y].piece.color == 'black' and 
        (x != 0 and x !=1) and (y != 0 and y != 0) and self.gamestate[x][y].piece.stage == KING and 
        (self.gamestate[x-1][y-1].piece.color == 'red' and
        self.gamestate[x-2][y-2].piece.value == '_')):

            self.gamestate[x-2][y-2].avaliable = True

            self.gamestate[x-1][y-1].piece.taken = True
            self.gamestate[x-1][y-1].piece.value = 'X'


        # Bottom Left
        if (self.gamestate[x][y].piece.color == 'red' and 
        (x != 0 and x != 1) and (y != 0 and y != 1) and 
        (self.gamestate[x-1][y-1].piece.color == 'black' and 
        self.gamestate[x-2][y-2].piece.value == '_')):
            self.gamestate[x-2][y-2].avaliable = True

            self.gamestate[x-1][y-1].piece.taken = True
            self.gamestate[x-1][y-1].piece.value = 'X'

        # Bottom Right
        if (self.gamestate[x][y].piece.color == 'red' and 
        (x != 7 and x != 6) and (y != 0 and y != 1) and 
        (self.gamestate[x+1][y-1].piece.color == 'black' and 
        self.gamestate[x+2][y-2].piece.value == '_')):

            self.gamestate[x+2][y-2].avaliable = True

            self.gamestate[x+1][y-1].piece.taken = True
            self.gamestate[x+1][y-1].piece.value = 'X'

        if (self.gamestate[x][y].piece.color == 'red' and 
        (x != 0 and x !=1) and (y != 7 and y != 6) and self.gamestate[x][y].piece.stage == KING and 
        (self.gamestate[x-1][y+1].piece.color == 'black' and 
        self.gamestate[x-2][y+2].piece.value == '_')):

            self.gamestate[x-2][y+2].avaliable = True

            self.gamestate[x-1][y+1].piece.taken = True
            self.gamestate[x-1][y+1].piece.value = 'X'
        
        if (self.gamestate[x][y].piece.color == 'red' and 
        (x != 7 and x != 6) and (y != 7 and y != 6) and self.gamestate[x][y].piece.stage == KING and 
        (self.gamestate[x+1][y+1].piece.color == 'black' and 
        self.gamestate[x+2][y+2].piece.value == '_')):

            self.gamestate[x+2][y+2].avaliable = True

            self.gamestate[x+1][y+1].piece.taken = True
            self.gamestate[x+1][y+1].piece.value = 'X'

        else:
            self.move_taken = False



    def black_avaliable(self,x,y):

        # left side
        # [x-1][y+1]          # x != 0 and y != 7      # upper
        # [x-1][y-1]          # x != 0 and y != 0      # lower    # king
        # Right Side
        # [x+1][y+1]          # x != 7 and y != 7      # upper
        # [x+1][y-1]          # x != 7 and y != 0      # lower    # king

        # Conditions
        # There is your own piece               != self.g_state.gamestate and
        # There is an opponent piece
        # You are Either a kind or Regular


        # upper left
        if x != 0 and y != 7:
            if self.gamestate[x-1][y+1].piece.value == '_':
                self.gamestate[x-1][y+1].avaliable = True
            elif (self.gamestate[x-1][y+1].piece.color == 'red') and x != 1:
                self.take_move(x,y)
        

        # bottom left
        if x != 0 and y != 0:
            if (self.gamestate[x-1][y-1].piece.value == '_' and
                self.gamestate[x][y].piece.stage == KING):

                self.gamestate[x-1][y-1].avaliable = True

            elif (self.gamestate[x-1][y-1].piece.color == 'red' and
                self.gamestate[x][y].piece.stage == KING):
                self.take_move(x,y)

        # upper right
        if x != 7 and y != 7:
            if self.gamestate[x+1][y+1].piece.value == '_':

                self.gamestate[x+1][y+1].avaliable = True

            elif (self.gamestate[x+1][y+1].piece.color == 'red'):
                self.take_move(x,y)
            

        # bottom right
        if x != 7 and y != 0:
            if (self.gamestate[x+1][y-1].piece.value == '_' and
                self.gamestate[x][y].piece.stage == KING):

                self.gamestate[x+1][y-1].avaliable = True

            elif (self.gamestate[x+1][y-1].piece.color == 'red' and
                self.gamestate[x][y].piece.stage == KING):
                self.take_move(x,y)

    def black_take_avaliable(self,x,y):
        if x != 0 and y != 7:
            if (self.gamestate[x-1][y+1].piece.color == 'red') and x != 1:
                self.take_move(x,y)
        

        # bottom left
        if x != 0 and y != 0:
            if (self.gamestate[x-1][y-1].piece.color == 'red' and
                self.gamestate[x][y].piece.stage == KING):
                self.take_move(x,y)

        # upper right
        if x != 7 and y != 7:
            if (self.gamestate[x+1][y+1].piece.color == 'red'):
                self.take_move(x,y)
            

        # bottom right
        if x != 7 and y != 0:
            if (self.gamestate[x+1][y-1].piece.color == 'red' and
                self.gamestate[x][y].piece.stage == KING):
                self.take_move(x,y)
        else:
            self.move_taken = False


    def red_avaliable(self,x,y):


        # upper left
        if x != 0 and y != 7:
            if (self.gamestate[x-1][y+1].piece.value == '_' and 
            self.gamestate[x][y].piece.stage == KING):
                self.gamestate[x-1][y+1].avaliable = True
            elif (self.gamestate[x-1][y+1].piece.color == 'black' and 
                self.gamestate[x][y].piece.stage == KING):
                self.take_move(x,y)

        # bottom left
        if x != 0 and y != 0:
            if (self.gamestate[x-1][y-1].piece.value == '_'):
                self.gamestate[x-1][y-1].avaliable = True

            elif (self.gamestate[x-1][y-1].piece.color == 'black') and x != 1:
                self.take_move(x,y)

        # upper right
        if x != 7 and y != 7:
            if (self.gamestate[x+1][y+1].piece.value == '_' and
                self.gamestate[x][y].piece.stage == KING):

                self.gamestate[x+1][y+1].avaliable = True

            elif (self.gamestate[x+1][y+1].piece.value == 'black' and
                self.gamestate[x][y].piece.stage == KING):
                self.take_move(x,y)
            

        # bottom right
        if x != 7 and y != 0:
            if (self.gamestate[x+1][y-1].piece.value == '_'):
                self.gamestate[x+1][y-1].avaliable = True

            elif (self.gamestate[x+1][y-1].piece.color == 'black'):
                self.take_move(x,y)



class Game():

    def __init__(self):
        self.board = Board()
        self.action = Action()
        self.g_state = GameState()


    def select_cordinates(self,x,y):
        cord = [-200, -150, -100, -50, 0, 50, 100, 150, 200]
        x_1= -1
        y_1= -1
    

        for xcord in range(8):
            if cord[xcord] <= x:
                x_1 +=1

        for ycord in range(8):
            if cord[ycord] <= y:
                y_1 +=1

        return x_1, y_1




    def Black_Select(self,x,y):
        if self.g_state.check_end_game() == True:
            turtle.bye()
            print("GAME HAS ENDED!")
        
        # first click
        x_1, y_1 = self.select_cordinates(x,y)
        self.action.x = x_1
        self.action.y = y_1

        # print('action black', self.action.x,self.action.y)
        # print('turn ', self.g_state.turn)
        # print('move taken', self.g_state.move_taken)
        # print('piece selected', self.g_state.gamestate[self.action.x][self.action.y].piece.color)

        if self.g_state.turn == 'black':
            if self.g_state.gamestate[self.action.x][self.action.y].piece.color == 'black':
                # if self.g_state.move_taken == False:
                self.g_state.gamestate[self.action.x][self.action.y].piece.selected = True
                self.g_state.black_avaliable(self.action.x,self.action.y)
                self.g_state.Update_GameState()
                self.action.save_last_click_x = self.action.x
                self.action.save_last_click_y = self.action.y
                turtle.onscreenclick(self.black_move)

            else:
                print("Please select black")





    def black_move(self,x,y):
        x_1, y_1 = self.select_cordinates(x,y)
        print('black move')

        # Taken Move
        if self.g_state.gamestate[x_1][y_1].avaliable == True and self.g_state.gamestate[x_1][y_1].piece.selected != True:
            self.g_state.gamestate[x_1][y_1] = self.g_state.gamestate[self.action.save_last_click_x][self.action.save_last_click_y]
            self.g_state.gamestate[self.action.save_last_click_x][self.action.save_last_click_y] = Square(Pieces('_'))
            self.g_state.remove_piece(x_1,y_1)

            self.g_state.Clean_Avaliable()
            self.g_state.Update_GameState()
            self.g_state.turn = 'red'
            self.g_state.print_board()
            self.red_select()

        if self.g_state.gamestate[x_1][y_1].piece.selected == True and self.g_state.turn == 'black' and self.g_state.move_taken == False:
            self.g_state.gamestate[x_1][y_1].piece.selected = False
            self.g_state.Clean_Avaliable()
            self.g_state.Update_GameState()
            turtle.onscreenclick(self.Black_Select)


    def red_select(self):
        if self.g_state.check_end_game() == True:
            turtle.bye()
            print("GAME HAS ENDED!")
        moves = []
        for row in range(NUM_SQUARES):
            for col in range(NUM_SQUARES):
                moves.append((row,col))


        while True:

            self.action.x,self.action.y = moves[random.randrange(0,len(moves))]


            if self.g_state.turn == 'red':
                if self.g_state.gamestate[self.action.x][self.action.y].piece != '_':
                    if self.g_state.gamestate[self.action.x][self.action.y].piece.color == 'red':
                        self.g_state.gamestate[self.action.x][self.action.y].piece.selected = True
                    
                        self.g_state.red_avaliable(self.action.x,self.action.y)
                        self.g_state.Update_GameState()
                        self.action.save_last_click_x = self.action.x
                        self.action.save_last_click_y = self.action.y
                        self.red_move()
                        if self.g_state.turn == 'black':
                            break
                                
            moves.remove((self.action.x,self.action.y))
        print("red move")
        self.g_state.print_board()
        turtle.onscreenclick(self.Black_Select)
                

    def red_move(self):
        new_moves = []
        for row in range(NUM_SQUARES):
            for col in range(NUM_SQUARES):
                new_moves.append((row,col))

        while True:

            if len(new_moves) != 0:
                x_1,y_1 = new_moves[random.randrange(0,len(new_moves))]

            if self.g_state.gamestate[x_1][y_1].avaliable == True and self.g_state.gamestate[x_1][y_1].piece.selected != True:
                self.g_state.gamestate[x_1][y_1] = self.g_state.gamestate[self.action.save_last_click_x][self.action.save_last_click_y]
                self.g_state.gamestate[self.action.save_last_click_x][self.action.save_last_click_y] = Square(Pieces('_'))
                self.g_state.remove_piece(x_1,y_1)
                self.g_state.Clean_Avaliable()
                self.g_state.Update_GameState()
                self.g_state.turn = 'black'
                break
            if len(new_moves) == 0:
                break
            new_moves.remove((x_1,y_1))
        

    def Select_Piece(self):
        turtle.onscreenclick(self.Black_Select)

    def Create_Game(self):
        #try:
        self.board.Create_Board()
        self.g_state.Create_GameState(self.board.board_size)
        self.g_state.Update_GameState()
        turtle.onscreenclick(self.Black_Select)
        turtle.done()
        #except Exception as e:
        #    pass

def main():
    #try:
    Create_Game = Game()
    Create_Game.Create_Game()
    #except Exception as e:
    #    pass


if __name__ == '__main__':
    main()


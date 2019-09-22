package C_8_Recursion_and_Dynamic_Programming;

public class PaintFill {
    enum Color { BLACK, WHITE, GREEN, YELLOW, RED}

    static boolean paintScreen(Color[][] screen, int r, int c, Color newColor){
        if(screen[r][c] == newColor)
            return false;
        return paintScreen(screen,r,c,screen[r][c],newColor);
    }


    static boolean paintScreen(Color[][] screen, int r, int c, Color oldColor, Color newColor){
        if(c > screen[0].length || r >  screen.length || r<0||c<0)
            return false;
        if(screen[r][c] != oldColor)
            return false;
        else{
            screen[r][c] = newColor;
            paintScreen(screen,r-1,c,oldColor,newColor);
            paintScreen(screen,r+1,c,oldColor,newColor);
            paintScreen(screen,r,c-1,oldColor,newColor);
            paintScreen(screen,r,c+1,oldColor,newColor);
        }
        return true;
    }

    static void printScreen(Color[][] screen){
        for(int r = 0; r < screen.length; r++){
            for(int c = 0; c < screen[0].length; c++){
                System.out.print(screen[r][c]+" ");
            }
            System.out.println();
        }
    }

    static int randomInt(int n){
        return (int)(Math.random()*n);
    }
    public static void main(String[] args) {
        int n = 10;
        Color[][] screen = new Color[n][n];
        for(int i=0;i<screen.length;i++){
            for(int j=0;j<screen[0].length;j++){
                screen[i][j]= Color.BLACK;
            }
        }

        for(int i = 0; i < 100; i++){
            screen[randomInt(n)][randomInt(n)] = Color.GREEN;
        }

        printScreen(screen);
        System.out.println();
        paintScreen(screen,2,2,Color.WHITE);
        printScreen(screen);

    }
}

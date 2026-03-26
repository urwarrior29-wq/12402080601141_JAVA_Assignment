// Matrix class with constructors, transpose and multiplication

class Matrix {
    int row, col;
    int mat[][];
	
	 java.util.Scanner sc = new java.util.Scanner(System.in);

    // default constructor (create 2x2 matrix)
    Matrix() {
        row = 2;
        col = 2;
        mat = new int[row][col];

        // initializing with some values
        mat[0][0] = 1;
        mat[0][1] = 2;
        mat[1][0] = 3;
        mat[1][1] = 4;
    }

    // parameterized constructor (create matrix of given size)
    Matrix(int r, int c) {
        row = r;
        col = c;
        mat = new int[row][col];
    }

    // function to input values
    void input() {
       

        // taking input from user
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                System.out.print("Enter element ["+i+"]["+j+"]: ");
                mat[i][j] = sc.nextInt();
            }
        }
    }

    // function to display matrix
    void display() {
        System.out.println("Matrix is:");
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    // transpose of matrix
    void transpose() {
        System.out.println("Transpose of Matrix:");

        // rows become columns and vice versa
        for(int i=0;i<col;i++) {
            for(int j=0;j<row;j++) {
                System.out.print(mat[j][i] + " ");
            }
            System.out.println();
        }
    }

    // matrix multiplication
    void multiply(Matrix m2) {
        // condition for multiplication
        if(this.col != m2.row) {
            System.out.println("Multiplication not possible");
            return;
        }

        int result[][] = new int[this.row][m2.col];

        // multiplying matrices
        for(int i=0;i<this.row;i++) {
            for(int j=0;j<m2.col;j++) {
                for(int k=0;k<this.col;k++) {
                    result[i][j] += this.mat[i][k] * m2.mat[k][j];
                }
            }
        }

        // display result
        System.out.println("Multiplication Result:");
        for(int i=0;i<this.row;i++) {
            for(int j=0;j<m2.col;j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// Main class
public class Program2 {
    public static void main(String args[]) {

        // creating first matrix
        Matrix m1 = new Matrix(2,2);
        m1.input();
        m1.display();

        // creating second matrix
        Matrix m2 = new Matrix(2,2);
        m2.input();
        m2.display();

        // transpose of first matrix
        m1.transpose();

        // multiplication of matrices
        m1.multiply(m2);
    }
}
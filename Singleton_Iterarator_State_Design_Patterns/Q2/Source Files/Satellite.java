public class Satellite implements Iterator{

    int position = 0;
    int [][] matrix;
    int [] output;
    public Satellite(int[][] matrix)
    {
        this.matrix = matrix;
        output = new int [matrix.length * matrix[0].length];
        this.traverse();
    }
    /**
     * Function that traverses the matrix spirally and saves the order to 1D array.
     */
    private void traverse()
    {
        int row_count = matrix.length;
        int col_count = matrix[0].length;
        double iterate_count = row_count < col_count ? row_count : col_count;
        iterate_count =  Math.ceil(iterate_count / 2);
        int counter = 0;
        for(int i = 0 ; i < iterate_count ; ++i)
        {
            for(int j = i ; j < col_count - i - 1  ; ++j)
            {
                output[counter++] = matrix[i][j];
                 
            }
            for(int j = i ; j < row_count - i - 1 ; ++j)
            {
                output[counter++] = matrix[j][col_count - i - 1];
            }
            for(int j = i ; j < col_count - i - 1 ; ++j)
            {
                output[counter++] = matrix[row_count- i - 1][col_count - j - 1];
            }
            for(int j = i ; j < row_count - i - 1; ++j)
            {
                output[counter++] = matrix[row_count - j - 1][i];
            }
        }
    }
    
    /** 
     * @return boolean that is true if the iterator has next element.
     */
    @Override
    public boolean hasNext() {
        if(position >= output.length)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    
    /** 
     * @return Object returns the next object of iterator.
     */
    @Override
    public Object next() {
        int single_output = output[position];
        position++;
        return single_output;
    }
    
    
}

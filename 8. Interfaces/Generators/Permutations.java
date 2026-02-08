import java.util.Arrays;

public class Permutations implements Generator<int[]> {
    private int tamanho;
    private int[] array;
    private boolean tem_proxima;

    public Permutations(int tamanho) {
        this.tamanho = tamanho;
        reset();
    }

    @Override
    public void reset() {
        this.array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = i;
        }
        this.tem_proxima = true;
    }

    @Override
    public boolean is_over() {
        return !tem_proxima;
    }

    @Override
    public int[] next() {
        int[] resultado = array.clone();
        
        // encontra pivô
        int i = tamanho - 2;
        while (i >= 0 && array[i] >= array[i + 1]) {
            i--;
        }
        
        if (i < 0) {
            // n permutacao
            tem_proxima = false;
        } else {
            // elemento para troca
            int j = tamanho - 1;
            while (j > i && array[j] <= array[i]) {
                j--;
            }
            
            // trocar
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            
            // reverter o sufixo
            int left = i + 1;
            int right = tamanho - 1;
            while (left < right) {
                temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        
        return resultado;
    }
    
    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}

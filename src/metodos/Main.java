package metodos;

public class Main {

	public static void main(String[] args) { 
        int N = 1000;
        int vet[] = new int[N];
        
        cria(N, vet, 0);
 
        int vet1[] = vet.clone();
        int vet2[] = vet.clone();
        int vet3[] = vet.clone();
        int vet4[] = vet.clone();        
        int vet5[] = vet.clone();
        int vet6[] = vet.clone();

        System.out.println("Ordenado");
        
        //Insertion
        double start3 = System.currentTimeMillis();
        insertion(vet1,N);
        double finish3 = System.currentTimeMillis();
        double total3 = finish3 - start3;
        System.out.println("Tempo Insertion: " + total3+" ms");
        
                
        //Bubble
        double start4 = System.currentTimeMillis();
        bubbleSort(vet2);
        double finish4 = System.currentTimeMillis();
        double total4 = finish4 - start4;
        System.out.println("Tempo bubble: " + total4+" ms");
        
        
        //Merge
        double start10 = System.currentTimeMillis();
        mergeSort(vet3, 0, (N-1));
        double finish10 = System.currentTimeMillis();
        double total10 = finish10 - start10;
        System.out.println("Tempo Merge: " + total10+" ms");
        
        
        //Heap
        double start7 = System.currentTimeMillis();
        heapSort(vet4);
        double finish7 = System.currentTimeMillis();
        double total7 = finish7 - start7;
        System.out.println("Tempo Heap: " + total7+" ms");
        
        
        //Shell
        double start8 = System.currentTimeMillis();
        shellSort(vet5);
        double finish8 = System.currentTimeMillis();
        double total8 = finish8 - start8;
        System.out.println("Tempo Shell: " + total8+" ms");
        
                
        //Quick
        double start6 = System.currentTimeMillis();
        vet6 = quick(vet6, 0, (N-1));
        double finish6 = System.currentTimeMillis();
        double total6 = finish6 - start6;
        System.out.println("Tempo Quick: " + total6+" ms");
        
        

            
        
        
        
    }
    
    
    public static int[] cria(int N, int vet[], int tipo) {
        // tipo: 
        //      0 para numeros aleatórios
        //      1 para vetor ordenado
        //      2 para vetor em ordem inversa

        switch (tipo) {
            case 0:
                for (int i = 0; i < N; i++) {
                    vet[i] = (int) (Math.random() * N) + 1;
                }
                break;
            case 1:
                for (int i = 0; i < N; i++) {
                    vet[i] = i + 1;
                }
                break;
            case 2:
                for (int i = 0; i < N; i++) {
                    vet[i] = N - i;
                }
                break;
        }
        return vet;
    }
    
    //Insertion
    public static int[] insertion(int[] vet4, int N) {

        int i, j, eleito;

        for (i = 1; i < N; i++) {

            eleito = vet4[i];

            j = i;

            while ((j > 0) && (vet4[j - 1] > eleito)) {
                vet4[j] = vet4[j - 1];
                j = j - 1;
            }
            vet4[j] = eleito;
        }

        return vet4;
    }
    
    //Bubble
    public static int[] bubbleSort(int vet5[]){
            boolean troca = true;
            int aux;
            while (troca) {
                troca = false;
                for (int i = 0; i < vet5.length - 1; i++) {
                    if (vet5[i] > vet5[i + 1]) {
                        aux = vet5[i];
                        vet5[i] = vet5[i + 1];
                        vet5[i + 1] = aux;
                        troca = true;
                    }
                }
            }
            return vet5;
    }
    
    //Merge
    public static void mergeSort(int[] array, int inicio, int fim) {
	if (fim <= inicio) {
		return;
	}
	int meio = (inicio + fim) / 2;
	mergeSort(array, inicio, meio);
	mergeSort(array, meio + 1, fim);
	int[] A = new int[meio - inicio + 1];
	int[] B = new int[fim - meio];
	for (int i = 0; i <= meio - inicio; i++) {
		A[i] = array[inicio + i];
	}
	for (int i = 0; i <= fim - meio - 1; i++) {
		B[i] = array[meio + 1 + i];
	}
	int i = 0;
	int j = 0;
	for (int k = inicio; k <= fim; k++) {
		if (i < A.length && j < B.length) {
			if (A[i] < B[j]) {
				array[k] = A[i++];
			} else {
				array[k] = B[j++];
			}
		} else if (i < A.length) {
			array[k] = A[i++];
		} else if (j < B.length) {
			array[k] = B[j++];
		}
	}
        
    }
    
    //Heap
    public static int[] heapSort(int[] v) {
        buildMaxHeap(v);
        int n = v.length;

        for (int i = v.length - 1; i > 0; i--) {
            swap(v, i, 0);
            maxHeapify(v, 0, --n);
        }
        
        return v;
    }

    private static void buildMaxHeap(int[] v) {
        for (int i = v.length / 2 - 1; i >= 0; i--)
            maxHeapify(v, i, v.length);

    }

    private static void maxHeapify(int[] vetor, int pos, int tamanhoDoVetor)  
     {  

         int max = 2 * pos + 1, right = max + 1;  
         if (max < tamanhoDoVetor)  
         {  

             if (right < tamanhoDoVetor && vetor[max] < vetor[right])  
                 max = right;

             if (vetor[max] > vetor[pos])  
             {  
                 swap(vetor, max, pos);  
                 maxHeapify(vetor, max, tamanhoDoVetor);  
             }  
         }  
     }

    public static void swap(int[] v, int j, int aposJ) {
        int aux = v[j];
        v[j] = v[aposJ];
        v[aposJ] = aux;
    }
    
    
    //Shell
    public static int[] shellSort(int[] nums) {
    int h = 1;
    int n = nums.length;
    while(h < n)
            h = h * 3 + 1;
    h = h / 3;
    int c, j;
    while (h > 0) {
        for (int i = h; i < n; i++) {
            c = nums[i];
            j = i;
            while (j >= h && nums[j - h] > c) {
                nums[j] = nums[j - h];
                j = j - h;
            }
            nums[j] = c;
        }
        h = h / 2;
    }
    
    return nums;
}
    
    //Quick
    static int[] quick(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = separar(vetor, inicio, fim);
            quick(vetor, inicio, posicaoPivo - 1);
            quick(vetor, posicaoPivo + 1, fim);
        }
       
        return  vetor;
    }

    static int separar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (vetor[i] <= pivo) {
                i++;
            } else if (pivo < vetor[f]) {
                f--;
            } else {
                int troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
    }
        
}    




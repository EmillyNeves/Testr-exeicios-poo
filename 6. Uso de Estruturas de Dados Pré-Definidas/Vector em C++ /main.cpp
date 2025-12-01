#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

int main()
{
    std::vector<int> numeros;
    int qtd_op;
    std::string op;

    std::cin >> qtd_op;

    for (int i = 0; i < qtd_op; i++)
    {
        std::cin >> op;
        
        int num;

        if (op.compare("INSERIR") == 0)
        {
            std::cin >> num;
            numeros.push_back(num);
        }
        else if (op.compare("REMOVER") == 0)
        {
            num = numeros.back(); 
            std::cout << num << std::endl;
            numeros.pop_back();
        }
        else if (op.compare("VER") == 0)
        {
            std::cin >> num;
            std::cout << numeros[num] << std::endl;
        }
        else if (op.compare("MOSTRAR") == 0)
        {
            for (int n : numeros)
            {
                std::cout << n << std::endl;
            }
        }
        else if (op.compare("TAMANHO") == 0)
        {
            std::cout << numeros.size() << std::endl;
        }
        else if (op.compare("ORDENAR") == 0)
        {
            std::sort(numeros.begin(), numeros.end());
        }
        else if (op.compare("BUSCAR") == 0)
        {
            std::cin >> num;
            std::vector<int>::iterator it = std::find(numeros.begin(), numeros.end(), num);

            if (it != numeros.end())
            {
                int index = std::distance(numeros.begin(), it);
                std::cout << index << std::endl;
            }
            else
            {
                std::cout << -1 << std::endl;
            }
        }
    }

    return 0;
}
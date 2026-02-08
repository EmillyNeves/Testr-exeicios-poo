#include <iostream>
#include <vector>
#include <iomanip>
#include <limits>

#include "Investimento.hpp"
#include "RendaFixa.hpp"
#include "Imovel.hpp"
#include "Acao.hpp"

using namespace std;

int main() {
    int num;
    
    cin >> num;

    vector<Investimento*> carteira;

    for (int i = 0; i < num; ++i) {
        string tipo, nome;
        double valor_inicial;

        cin >> tipo >> nome >> valor_inicial;

        if (tipo == "RendaFixa") {
            int duracao;
            double taxa;
            cin >> duracao >> taxa;
            carteira.push_back(new RendaFixa(nome, valor_inicial, duracao, taxa));
        } 
        else if (tipo == "Imovel") {
            double area, taxa_m2, aluguel;
            int meses;
            cin >> area >> taxa_m2 >> aluguel >> meses;
            carteira.push_back(new Imovel(nome, valor_inicial, area, taxa_m2, aluguel, meses));
        } 
        else if (tipo == "Acoes") {
            double taxa_var;
            cin >> taxa_var;
            carteira.push_back(new Acao(nome, valor_inicial, taxa_var));
        }
    }

    double soma_retornos = 0.0;
    string nome_maior_retorno = "";
    double maior_retorno = -numeric_limits<double>::infinity(); 

    cout << fixed << setprecision(2);

    for (Investimento* inv : carteira) {
        double ret = inv->retorno();
        cout << inv->get_nome() << " " << ret << endl;

        soma_retornos += ret;

        if (ret > maior_retorno) {
            maior_retorno = ret;
            nome_maior_retorno = inv->get_nome();
        }
    }

    cout << soma_retornos << endl;
    cout << nome_maior_retorno << endl; 

    for (Investimento* inv : carteira) {
        delete inv;
    }
    carteira.clear();

    return 0;
}
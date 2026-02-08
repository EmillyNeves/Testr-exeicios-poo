#include <iostream>
#include <vector>
#include <string>
#include <iomanip>
#include "Funcionario.hpp"
#include "Freelancer.hpp"
#include "CLT.hpp"
#include "Estagiario.hpp"
#include "Vendedor.hpp"

using namespace std;

int main()
{
    int n;
    cin >> n;
    vector<Funcionario *> funcionarios;

    for (int i = 0; i < n; i++)
    {
        string tipo, nome;
        cin >> tipo;

        if (tipo == "Freelancer")
        {
            int horas;
            double valor_hora;
            cin >> nome >> horas >> valor_hora;

            Funcionario *f = new Freelancer(nome, horas, valor_hora);
            funcionarios.push_back(f);
        }
        else if (tipo == "CLT")
        {
            double salario_base, ticket, fgts, irrf;
            cin >> nome >> salario_base >> ticket >> fgts >> irrf;

            Funcionario *f = new CLT(nome, salario_base, ticket, fgts, irrf);
            funcionarios.push_back(f);
        }
        else if (tipo == "Estagiario")
        {
            double salario_base, auxilio;
            cin >> nome >> salario_base >> auxilio;

            Funcionario *f = new Estagiario(nome, salario_base, auxilio);
            funcionarios.push_back(f);
        }
        else if (tipo == "Vendedor")
        {
            double salario_base, comissao;
            int bateu_meta_int;
            cin >> nome >> salario_base >> comissao >> bateu_meta_int;
            bool bateu_meta = (bateu_meta_int == 1);

            Funcionario *f = new Vendedor(nome, salario_base, comissao, bateu_meta);
            funcionarios.push_back(f);
        }
    }

    cout << fixed << setprecision(2);

    for (size_t i = 0; i < funcionarios.size(); i++)
    {
        cout << funcionarios[i]->get_nome() << " "
             << funcionarios[i]->salario() << endl;
    }

    if (funcionarios.size() > 0)
    {
        double maior_salario = funcionarios[0]->salario();
        double menor_salario = funcionarios[0]->salario();
        string nome_maior = funcionarios[0]->get_nome();
        string nome_menor = funcionarios[0]->get_nome();
        double gasto_total = 0.0;

        for (size_t i = 0; i < funcionarios.size(); i++)
        {
            double sal = funcionarios[i]->salario();
            string nome = funcionarios[i]->get_nome();

            gasto_total += sal;

            if (sal > maior_salario)
            {
                maior_salario = sal;
                nome_maior = nome;
            }

            if (sal < menor_salario)
            {
                menor_salario = sal;
                nome_menor = nome;
            }
        }

        cout << nome_maior << " " << maior_salario << endl;
        cout << nome_menor << " " << menor_salario << endl;
        cout << gasto_total << endl;
    }

    for (size_t i = 0; i < funcionarios.size(); i++)
    {
        delete funcionarios[i];
    }

    return 0;
}

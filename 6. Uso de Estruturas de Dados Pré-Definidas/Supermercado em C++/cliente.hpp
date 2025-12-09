#ifndef CLIENTE_HPP
#define CLIENTE_HPP

#include <string>
using namespace std;

class Cliente {
private:
    string nome;
    string cpf;

public:
    Cliente(string nome, string cpf);
    
    string getNome() const;
    string getCpf() const;
};

#endif

#ifndef _FUNCIONARIO_HPP_
#define _FUNCIONARIO_HPP_
#include <string>
class Funcionario
{
protected:
    std::string nome;

public:
    Funcionario();
    Funcionario(std::string nome);
    virtual double salario() = 0;
    std::string get_nome();
    ~Funcionario();
};
#endif // _FUNCIONARIO_HPP_

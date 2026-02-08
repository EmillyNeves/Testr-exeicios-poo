
#ifndef _FUN_CONTRATADO_HPP_
#define _FUN_CONTRATADO_HPP_
#include <string>
#include "Funcionario.hpp"
class FuncionarioContratado : public Funcionario
{
protected:
    double _salario_base;
    virtual double bonus() = 0;
    virtual double descontos() = 0;

public:
    FuncionarioContratado();
    FuncionarioContratado(std::string nome, double s);
    double salario() override;
    ~FuncionarioContratado();
};
#endif // _FUN_CONTRATADO_HPP_

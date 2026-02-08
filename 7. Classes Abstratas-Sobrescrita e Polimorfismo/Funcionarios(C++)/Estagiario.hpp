#ifndef _ESTAGIARIO_HPP_
#define _ESTAGIARIO_HPP_
#include <string>
#include "FuncionarioContratado.hpp"

class Estagiario : public FuncionarioContratado
{
private:
    double _a_transporte;

protected:
    double bonus() override;
    double descontos() override;

public:
    Estagiario(std::string nome, double salario_base, double auxilio);
    ~Estagiario() override;
};

#endif // _ESTAGIARIO_HPP_

#ifndef _VENDEDOR_HPP_
#define _VENDEDOR_HPP_
#include <string>
#include "FuncionarioContratado.hpp"

class Vendedor : public FuncionarioContratado
{
private:
    double _comissao;
    bool _bateu_meta;

protected:
    double bonus() override;
    double descontos() override;

public:
    Vendedor(std::string nome, double salario_base, double comissao, bool bateu_meta);
    ~Vendedor();
};

#endif // _VENDEDOR_HPP_

#include <cstdio>
#include <stdexcept>
#include "matriz.h"

Matriz ::Matriz(int n, int m)
{
    this->_alocar(n, m);
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            this->_data[i][j] = 0.0;
        }
    }
}

Matriz ::Matriz(int n, int m, const double *valores)
{
    this->_alocar(n, m);
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            this->_data[i][j] = valores[i * _m + j];
        }
    }
}

Matriz ::Matriz(const Matriz &other)
{
    this->_alocar(other._n, other._m);
    for (int i = 0; i < _n; i++)
    {
        for (int j = 0; j < _m; j++)
        {
            this->_data[i][j] = other._data[i][j];
        }
    }
}

Matriz &Matriz ::operator=(const Matriz &other)
{
    if (this == &other)
    {
        return *this;
    }

    this->_liberar();
    this->_alocar(other._n, other._m);

    for (int i = 0; i < _n; i++)
    {
        for (int j = 0; j < _m; j++)
        {
            this->_data[i][j] = other._data[i][j];
        }
    }

    return *this;
}

// --- Destrutor ---
Matriz ::~Matriz()
{
    this->_liberar();
}

// --- MÃ©todos estÃ¡ticos ---
Matriz Matriz ::zeros(int n, int m)
{
    return Matriz(n, m);
}
Matriz Matriz::ones(int n, int m)
{
    Matriz mat(n, m);
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            mat._data[i][j] = 1.0;
    return mat;
}
Matriz Matriz::eye(int n, int m)
{
    Matriz mat(n, m);
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
        {
            if (i == j)
                mat._data[i][j] = 1.0;
        }
    return mat;
}

// --- Operador + (matriz + matriz) ---
Matriz Matriz::operator+(const Matriz &other) const
{
    if (this->_n != other._n || this->_m != other._m)
    {
        throw std::runtime_error("Erro: Dimensoes incompativeis para soma.");
    }

    Matriz mat(this->_n, this->colunas());
    for (int i = 0; i < this->_n; i++)
        for (int j = 0; j < this->colunas(); j++)
        {
            mat._data[i][j] = this->_data[i][j] + other._data[i][j];
        }
    return mat;
}

// --- Operador + (matriz + escalar) ---
Matriz Matriz::operator+(double escalar) const
{
    Matriz mat(this->_n, this->_m);
    for (int i = 0; i < this->_n; i++)
        for (int j = 0; j < this->_m; j++)
        {
            mat._data[i][j] = this->_data[i][j] + escalar;
        }
    return mat;
}

// --- Operador * (matriz * escalar) ---
Matriz Matriz::operator*(double escalar) const
{
    Matriz mat(this->_n, this->_m);
    for (int i = 0; i< this->_n; i++)
        for (int j = 0; j < this->_m; j++)
        {
            mat._data[i][j] = this->_data[i][j] * escalar;
        }
    return mat;
}

// --- Operador * (matriz * matriz) ---
Matriz Matriz::operator*(const Matriz &other) const
{
    //(colunas de A == linhas de B)
    if (this->_m != other._n)
    {
        throw std::runtime_error("Erro: Dimensoes incompativeis para multiplicacao.");
    }

    int n_res = this->_n;
    int m_res = other._m;
    int k_common = this->_m;

    Matriz mat(n_res, m_res);
    for (int i = 0; i < n_res; ++i)
    {
        for (int j = 0; j < m_res; ++j)
        {
            for (int k = 0; k < k_common; ++k)
            {
                mat._data[i][j] += this->_data[i][k] * other._data[k][j];
            }
        }
    }
    return mat;
}

// --- MÃ©todo estÃ¡tico para ler uma matriz ---
Matriz Matriz::ler()
{
    int n, m;
    scanf("%d %d", &n, &m);

    Matriz mat(n, m);

    for (int i = 0; i < n; ++i)
    {
        for (int j = 0; j < m; ++j)
        {
            scanf("%lf", &mat._data[i][j]);
        }
    }
    return mat;
}

// --- MÃ©todo print ---
void Matriz::print() const
{
    for (int i = 0; i < this->_n; i++)
    {
        for (int j = 0; j < this->_m; j++)
        {
            printf("%.2f", this->_data[i][j]);
            if (j < this->_m - 1)
                printf(" ");
        }
        printf("\n");
    }
}

// --- MÃ©todos auxiliares ---
int Matriz::linhas() const
{
    return this->_n;
}
int Matriz::colunas() const
{
    return this->_m;
}
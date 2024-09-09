import jwt from "jsonwebtoken";

export const jwtmiddleware = (handler) => async (req, res) => {
    const token = req.headers.authorization?.split('')[1];

    if (!token) {
        return res.status(401).json({ message: 'Token ausente ou inválido.' }); // Obtém o token do header
    }

    try {
        const decoded = jwt.verify(token, process.env.JWT_SECRET); // Verifica o token
        req.user = decoded; // Armazena os dados do usuário no request
        return handler(req, res); // Continua para o próximo handler
    } catch (error) {
        return res.status(401).json({ message: 'Token inválido' });
    }
}
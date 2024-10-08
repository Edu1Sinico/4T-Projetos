import User from "@/models/User";
import connectMongo from "@/utils/dbConnect";
import { NextResponse } from "next/server";
import jwt from "jsonwebtoken";

export async function POST(request) {
    const { email, password } = await request.json();
    await connectMongo();
    try {
        const user = await User.findOne({email})
        // Verificar se o User e se a senha bate
        if (user && (user.comparePassword(password))) {
            const token = jwt.sign({ userId: user._id },
                process.env.JWT_SECRET, { expiresIn: '1h' }
            );
            return NextResponse.json({ token });
        } else {
            return NextResponse.json({ success: false }, { status: 400 });
        }
    } catch (error) {
        return NextResponse.json({ success: false }, { status: 404 });
    }
}
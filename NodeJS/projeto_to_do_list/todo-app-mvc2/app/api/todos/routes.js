// GET e POST
import { getTodos, createTodos } from "@/controllers/TodoController";
import { NextResponse } from "next/server";

// GET
export async function GET() {
    try {
        const todos = await getTodos(); //chamar o método do controller
        return NextResponse.json({ success: true, data: todos });
    } catch (error) {
        return NextResponse.json({ success: false }, { status: 400 });
    }
}

// POST
export async function POST(req) {
    try {
        const data = await req.json();
        const todo = await createTodos(data);
        return NextResponse.json({ success: true, data: todo });
    } catch (error) {
        return NextResponse.json({ success: false }, { status: 400 });
    }
}

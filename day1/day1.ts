import {readFile} from 'fs/promises';

async function main() {
    const data = await readFile('input.txt', 'utf-8');
    console.log(data);
}

main();
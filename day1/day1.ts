import {readFile} from 'fs/promises';
import MinHeap from 'heap-js';

async function day1_with_heaps() {
    const data = await readFile('input.txt', 'utf-8');
    const lines = data.split('\n');
    const left = new MinHeap<number>();
    const right = new MinHeap<number>();

    for (const line of lines) {
        if (!line.trim()) {
            continue
        }
        const parts = line.trim().split(/\s+/).map(Number);
        console.assert(parts.length === 2, 'Invalid input');
        const [left_num, right_num] = parts
        left.push(left_num)
        right.push(right_num)
    }

    let total_distance = 0
    while (true) {
        if (left.isEmpty() || right.isEmpty()) {
            console.log("Done")
            break
        }
        const left_smallest = left.pop()
        const right_smallest = right.pop()
        const diff = Math.abs(left_smallest - right_smallest)
        total_distance += diff
    }
    console.log(total_distance)
}

async function day1_sorted_lits() {
    const data = await readFile('input.txt', 'utf-8');
    const lines = data.split('\n');
    const left: number[] = [];
    const right: number[] = [];

    for (const line of lines) {
        if (!line.trim()) {
            continue
        }
        const parts = line.trim().split(/\s+/).map(Number);
        console.assert(parts.length === 2, 'Invalid input');
        const [left_num, right_num] = parts
        left.push(left_num)
        right.push(right_num)
    }

    // a - b => negative, a comes before b (a < b)
    // a - b => positive, b comes before a (a > b)
    // a - b => 0, order does not change
    left.sort((a, b) => a - b);
    right.sort((a, b) => a - b);
    console.assert(left.length == right.length, "Both lists should have the same size")

    let total_distance = 0
    for (let i = 0; i < left.length; i++) {
        const left_smallest = left[i]
        const right_smallest = right[i]
        const diff = Math.abs(left_smallest - right_smallest)
        total_distance += diff
    }
    console.log(total_distance)
}

async function day1_part_two() {
    const data = await readFile('input.txt', 'utf-8');
    const lines = data.split('\n');
    const left: number[] = [];
    const right: Record<number, number> = [];

    for (const line of lines) {
        if (!line.trim()) {
            continue
        }
        const parts = line.trim().split(/\s+/).map(Number);
        console.assert(parts.length === 2, 'Invalid input');
        const [left_num, right_num] = parts
        left.push(left_num)

        // Count the occurrences of numbers in the right array.
        if (right[right_num]){
            const right_occurences = right[right_num];
            right[right_num] = right_occurences + 1
        } else {
            right[right_num] = 1
        }
    }

    let total_distance = 0
    for (let i = 0; i < left.length; i++) {
        const left_num = left[i]
        // Does not appear in right list -> Skip
        if (!right[left_num])
        {
            continue
        }
        const num_occurences = right[left_num]
        const total_value = left_num * num_occurences
        total_distance += total_value
    }
    console.log(total_distance)
}

// day1_with_heaps().catch(console.error);
// day1_sorted_lits().catch(console.error);

async function measure() {
    console.time('day1_with_heaps');
    await day1_with_heaps();
    console.timeEnd('day1_with_heaps');

    console.time('day1_sorted_lits');
    await day1_sorted_lits();
    console.timeEnd('day1_sorted_lits');
}

// measure().catch(console.error);
day1_part_two().catch(console.error);
/**
 * 
 * @param original Original array
 * @param modified Modified array
 * @param oIdx Original array index
 * @param mIdx Modified array index
 * @param cIdx Command index
 * @param maxLength Maximum command array length
 * @return array of commands to apply to the original array in order to produce
 *         the modified array. Commands are add, remove, set, and move
 */
function arrayDelta(original, modified, oIdx, mIdx, cIdx, maxLength) {
	if (maxLength === undefined) {
		maxLength = original.length < modified.length ? modified.length	: original.length;
	}
	if (maxLength < 0) {
		return undefined;
	}
	// Skip equal elements.
	while (oIdx < original.length && mIdx < modified.length	&& original[oIdx] === modified[mIdx]) {
		++oIdx;
		++mIdx;
		++cIdx;
	}
	// If original has ended
	if (oIdx == original.length) {
		var ret = [];
		for (i = mIdx; i < modified.length; ++i) {
			ret.push({
				type : "add",
				value : modified[i]
			});
		}
		return ret.length > maxLength ? undefined : ret;
	}
	// If modified has ended
	if (mIdx == modified.length) {
		var ret = [];
		for (i = oIdx; i < original.length; ++i) {
			ret.push({
				type : "remove",
				pos : cIdx,
				value : original[i]
			});
		}
		return ret.length > maxLength ? undefined : ret;
	}
	// set
	var champion = arrayDelta(original, modified, oIdx + 1, mIdx + 1, cIdx + 1,	maxLength - 1);
	if (champion !== undefined) {
		champion.splice(0, 0, {
			type : "set",
			pos : cIdx,
			initialValue : original[oIdx],
			value : modified[mIdx]
		});
	}
	
	// move - try to move value in the original back so it matches the modified
	var idx = original.indexOf(modified[mIdx], oIdx);
	if (idx !== -1) {
		var or = original.slice(oIdx);
		or.splice(idx - oIdx, 1);
		var candidate = arrayDelta(or, modified, 0, mIdx + 1, cIdx + 1,	(champion === undefined ? maxLength : champion.length) - 1);
		if (candidate !== undefined) {
			candidate.splice(0, 0, {
				type : "move",
				pos : cIdx + idx - oIdx,
				initialValue : original[idx],
				newPos : cIdx
			});
			champion = candidate;
		}
	}

	// move - try to move value in the original forward so it matches the modified
	var idx = modified.indexOf(original[oIdx], mIdx);
	if (idx !== -1) {
		var or = original.slice(oIdx+1);
		or.splice(idx - mIdx, 0, original[oIdx]);
		var candidate = arrayDelta(or, modified, 0, mIdx, cIdx,	(champion === undefined ? maxLength : champion.length) - 1);
		if (candidate !== undefined) {
			candidate.splice(0, 0, {
				type : "move",
				pos : cIdx,
				initialValue : original[oIdx],
				newPos : cIdx + idx - mIdx
			});
			champion = candidate;
		}
	}

	// add - try to add elements to the original at current position so the next
	// element matches the modified
	idx = modified.indexOf(original[oIdx], mIdx);
	if (idx !== -1) {
		var candidate = arrayDelta(original, modified, oIdx + 1, idx + 1, cIdx
				+ idx - mIdx + 1, (champion === undefined ? maxLength
				: champion.length)
				- idx + mIdx);
		if (candidate !== undefined) {
			for (i = mIdx; i < idx; ++i) {
				candidate.splice(i - mIdx, 0, {
					type : "add",
					pos : cIdx + i - mIdx,
					value : modified[i]
				});
			}
			champion = candidate;
		}
	}
	// remove - try to remove elements from the original at current position so
	// the remaining element matches the modified
	idx = original.indexOf(modified[mIdx], oIdx);
	if (idx !== -1) {
		var candidate = arrayDelta(original, modified, idx + 1, mIdx + 1,
				cIdx + 1,
				(champion === undefined ? maxLength : champion.length) - idx + oIdx);
		if (candidate !== undefined) {
			for (i = oIdx; i < idx; ++i) {
				candidate.splice(i - oIdx, 0, {
					type : "remove",
					pos : cIdx + i - oIdx,
					initialValue : original[i]
				});
			}
			champion = candidate;
		}
	}
	return champion;
}

console.log(arrayDelta([ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ], [ 2, 3, 5, 6, 7, 8, 9, 10, 4, 1 ], 0, 0, 0));
